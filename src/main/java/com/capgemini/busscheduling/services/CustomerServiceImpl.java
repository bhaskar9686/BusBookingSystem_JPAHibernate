package com.capgemini.busscheduling.services;

import java.util.List;

import com.capgemini.busscheduling.beans.Availability;
import com.capgemini.busscheduling.beans.Feedback;
import com.capgemini.busscheduling.beans.Ticket;
import com.capgemini.busscheduling.beans.Users;
import com.capgemini.busscheduling.dao.BusBookingDAO;
import com.capgemini.busscheduling.dao.BusBookingDAOImpl;
import com.capgemini.busscheduling.dao.CustomerDAO;
import com.capgemini.busscheduling.dao.CustomerDAOImpl;

public class CustomerServiceImpl implements CustomerService {

	CustomerDAO dao = new CustomerDAOImpl();
	BusBookingDAO busDao = new BusBookingDAOImpl();
	@Override
	public Users registerCustomer(Users user) {
		return dao.registerCustomer(user);
	}

	@Override
	public Users loginCustomer(Integer id, String password) {
		return dao.loginCustomer(id, password);
	}

	@Override
	public Boolean updateCustomer(Users user) {
		return dao.updateCustomer(user);
	}

	@Override
	public Boolean deleteCustomer(Integer id) {
		return dao.deleteCustomer(id);
	}

	@Override
	public Ticket bookTicket(Ticket ticket) {
		return dao.bookTicket(ticket);
	}

	@Override
	public Boolean cancelTicket(Integer bookingId, Integer id) {
		return dao.cancelTicket(bookingId, id);
	}

	@Override
	public Ticket getTicketInfo(Integer bookingId) {
		return dao.getTicketInfo(bookingId);
	}

	@Override
	public Integer checkAvailability(Integer busId, String date) {
		return busDao.checkAvailability(busId, date);
	}

	@Override
	public List<Availability> checkAvailability(String source, String destination, String date) {
		return busDao.checkAvailability(source, destination, date);
	}

	@Override
	public Boolean writeFeedback(Feedback feed) {
		return dao.writeFeedback(feed);
	}



}
