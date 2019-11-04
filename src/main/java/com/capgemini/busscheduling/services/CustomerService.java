package com.capgemini.busscheduling.services;

import java.util.List;

import com.capgemini.busscheduling.beans.Availability;
import com.capgemini.busscheduling.beans.Feedback;
import com.capgemini.busscheduling.beans.Ticket;
import com.capgemini.busscheduling.beans.Users;

public interface CustomerService {
	public Users registerCustomer( Users user);
	public Users loginCustomer(Integer id, String password);
	public Boolean updateCustomer(Users user);
	public Boolean deleteCustomer(Integer id);
	public Ticket bookTicket(Ticket ticket);
	public Boolean cancelTicket(Integer bookingId, Integer id);
	public Ticket getTicketInfo(Integer bookingId);
	public Integer checkAvailability(Integer busId, String date);
	public List<Availability>checkAvailability(String source, String destination, String date);
	public Boolean writeFeedback(Feedback feed);
}
