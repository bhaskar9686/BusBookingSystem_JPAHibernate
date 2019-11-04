package com.capgemini.busscheduling.services;

import java.util.List;

import com.capgemini.busscheduling.beans.Availability;
import com.capgemini.busscheduling.beans.Bus;
import com.capgemini.busscheduling.beans.Feedback;
import com.capgemini.busscheduling.dao.BusBookingDAO;
import com.capgemini.busscheduling.dao.BusBookingDAOImpl;

public class BusBookingServiceImpl implements BusBookingService {

	BusBookingDAO dao = new BusBookingDAOImpl();
	@Override
	public Bus searchBus(Integer busId) {
		return dao.searchBus(busId);
	}

	@Override
	public List<Bus> showAllBuses() {
		return dao.showAllBuses();
	}

	@Override
	public Integer checkAvailability(Integer busId, String date) {
		return dao.checkAvailability(busId, date);
	}

	@Override
	public List<Availability> checkAvailability(String source, String destination, String tempDate) {
		return dao.checkAvailability(source, destination, tempDate);
	}

	@Override
	public List<Feedback> viewFeedback() {
		return dao.viewFeedback();
	}

}
