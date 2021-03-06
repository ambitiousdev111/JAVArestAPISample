package in.cozynest.cozyapis.dao;

import java.util.ArrayList;

import in.cozynest.cozyapis.model.Order;

public interface IOrderDao {
	public boolean exists(int pk);

	public long count();

	public Order create(Order Order);

	public Order update(Order Order);

	public void delete(Order Order);

	public ArrayList<Order> findAll();

	public Order findById(int id);

	public ArrayList<Order> findByDateOfOrder(String orderDate);

	public ArrayList<Order> findByUserId(int userId);

	public ArrayList<Order> findByGeneratedUserId(String userId);
	
	public ArrayList<Order> findByPhone(String phone);
}