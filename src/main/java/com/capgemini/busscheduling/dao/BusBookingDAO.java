package com.capgemini.busscheduling.dao;

import java.util.List;

import com.capgemini.busscheduling.beans.Availability;
import com.capgemini.busscheduling.beans.Bus;
import com.capgemini.busscheduling.beans.Feedback;

public interface BusBookingDAO {

	public Bus searchBus(Integer busId);
	public List<Bus> showAllBuses();
	public Integer checkAvailability(Integer busId, String date);
	public List<Availability>checkAvailability(String source, String destination, String date);
	public List<Feedback> viewFeedback();
}
