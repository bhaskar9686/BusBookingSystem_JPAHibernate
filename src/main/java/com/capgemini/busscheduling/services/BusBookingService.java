package com.capgemini.busscheduling.services;

import java.util.List;

import com.capgemini.busscheduling.beans.Availability;
import com.capgemini.busscheduling.beans.Bus;
import com.capgemini.busscheduling.beans.Feedback;

public interface BusBookingService {
	public Bus searchBus(Integer busId);
	public List<Bus> showAllBuses();
	public Integer checkAvailability(Integer busId, String date);
	public List<Availability>checkAvailability(String source, String destination, String tempDate);
	public List<Feedback> viewFeedback();
}
