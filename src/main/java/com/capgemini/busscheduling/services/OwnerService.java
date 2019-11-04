package com.capgemini.busscheduling.services;

import java.util.List;

import com.capgemini.busscheduling.beans.Availability;
import com.capgemini.busscheduling.beans.Bus;
import com.capgemini.busscheduling.beans.Ticket;
import com.capgemini.busscheduling.beans.Users;

public interface OwnerService {
	public Users loginOwner(Integer id, String password);
	public Bus addBus(Bus bus);
	public Boolean updateBus(Bus bus);
	public Boolean deleteBus(Integer busId);
	public List<Ticket>getTicketByBus(Integer busId,String date);
	public List<Ticket>getAllTicket(Integer id);
	public Boolean setBusAvailability(Availability availability);
}
