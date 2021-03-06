package in.cozynest.cozyapis.dao;

import java.util.ArrayList;

import in.cozynest.cozyapis.model.OrderedSubscription;
import in.cozynest.cozyapis.model.OrderedSubscription.OrderedSubscriptionStatus;

public interface IOrderedSubscriptionDao {

	public boolean exists(int pk);

	public long count();

	public OrderedSubscription create(OrderedSubscription orderedSubscription);

	public OrderedSubscription update(OrderedSubscription orderedSubscription);

	public void delete(OrderedSubscription orderedSubscription);

	public ArrayList<OrderedSubscription> findAll();

	public OrderedSubscription findById(int id);

	public ArrayList<OrderedSubscription> findByStartDate(String startDate);

	public ArrayList<OrderedSubscription> findByEndDate(String endDate);
	
	public ArrayList<OrderedSubscription> findByPlanType(String planType);

	public ArrayList<OrderedSubscription> findByUserId(int userId);

	public ArrayList<OrderedSubscription> findByGeneratedUserId(String generatedUserId);
	
	public ArrayList<OrderedSubscription> findByPhone(String phone);

	public ArrayList<OrderedSubscription> findByEndDateAndEndShift(String endDate, String endShift);

	public OrderedSubscriptionStatus getStatusById(int id);

}