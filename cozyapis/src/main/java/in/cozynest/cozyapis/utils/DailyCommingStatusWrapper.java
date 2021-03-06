package in.cozynest.cozyapis.utils;

import java.util.ArrayList;

import in.cozynest.cozyapis.model.OrderedSubscription.Shift;
import in.cozynest.cozyapis.model.SubscriptionPlan.PlanType;

public class DailyCommingStatusWrapper {
	
	private ArrayList<String> cancelledSubscriptiondates;
	private ArrayList<String> dailyCommingDates;
	private PlanType planType;
	private String currentDate;
	private Shift currentShift;

	public DailyCommingStatusWrapper(ArrayList<String> cancelledSubscriptiondates,
			ArrayList<String> dailyCommingDates, PlanType planType, String currentDate,
			Shift currentShift) {
		super();
		this.cancelledSubscriptiondates = cancelledSubscriptiondates;
		this.dailyCommingDates = dailyCommingDates;
		this.planType = planType;
		this.currentDate = currentDate;
		this.currentShift = currentShift;
	}

	public DailyCommingStatusWrapper() {
	}

	public ArrayList<String> getCancelledSubscriptiondates() {
		return cancelledSubscriptiondates;
	}

	public void setCancelledSubscriptiondates(ArrayList<String> cancelledSubscriptiondates) {
		this.cancelledSubscriptiondates = cancelledSubscriptiondates;
	}

	public ArrayList<String> getDailyCommingDates() {
		return dailyCommingDates;
	}

	public void setDailyCommingDates(ArrayList<String> dailyCommingDates) {
		this.dailyCommingDates = dailyCommingDates;
	}

	public PlanType getPlanType() {
		return planType;
	}

	public void setPlanType(PlanType planType) {
		this.planType = planType;
	}

	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	public Shift getCurrentShift() {
		return currentShift;
	}

	public void setCurrentShift(Shift currentShift) {
		this.currentShift = currentShift;
	}
}