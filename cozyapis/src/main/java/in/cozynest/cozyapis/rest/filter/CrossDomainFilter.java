package in.cozynest.cozyapis.rest.filter;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import in.cozynest.cozyapis.exception.UnauthorizedException;
import in.cozynest.cozyapis.model.User;
import in.cozynest.cozyapis.security.CryptoAlgo;
import in.cozynest.cozyapis.service.impl.UserServiceImpl;

@Provider
public class CrossDomainFilter implements ContainerResponseFilter {
	@Override
	public void filter(ContainerRequestContext creq, ContainerResponseContext cres) {
		cres.getHeaders().add("Access-Control-Allow-Origin", "*");
		cres.getHeaders().add("Access-Control-Allow-Headers",
				"origin, accept, authorization,X-Requested-With, Content-Type, X-Codingpedia");
		cres.getHeaders().add("Access-Control-Allow-Credentials", "true");
		cres.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
		cres.getHeaders().add("Access-Control-Max-Age", "1209600");

		if (cres.getStatus() != 200)
			return;
		String generatedUserId = null;
		User u = null;
		String authId = creq.getHeaderString("AuthId");
		if (authId == null)
			return;
		try {
			generatedUserId = new CryptoAlgo().decrypt("kelkarsirjiuserid", authId);
			if (generatedUserId != null)
				u = new UserServiceImpl().findByGeneratedUserId(generatedUserId);
		} catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException
				| InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException | IOException
				| NullPointerException e1) {
			e1.printStackTrace();
			if (u == null)
				return;
		}
		if (u == null)
			return;

		if (u.getUserTypeString().equals("ADMIN"))
			return;
		try {
			User user = (User) cres.getEntity();
			if (cres.getStatus() != 200)
				return;
			if (user.getId() != u.getId())
				throw new UnauthorizedException("Forbidden request");

		} catch (ClassCastException e) {
			if (cres.getStatus() == 200)
				return;
			try {
				List<User> users = (List<User>) cres.getEntity();
				boolean found = false;
				for (int i = 0; i < users.size(); i++) {
					if (users.get(i).getId() != u.getId()) {
						found = true;
						break;
					}
				}
				if (found)
					throw new UnauthorizedException("Request forbidden");
			} catch (ClassCastException cce) {
			}
		}
	}
}