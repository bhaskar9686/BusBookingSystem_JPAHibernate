package com.capgemini.busscheduling.dao;

import java.util.List;

import com.capgemini.busscheduling.beans.Availability;
import com.capgemini.busscheduling.beans.Bus;
import com.capgemini.busscheduling.beans.Ticket;
import com.capgemini.busscheduling.beans.Users;

public interface OwnerDAO {
	public Users loginOwner(Integer id, String password);
	public Bus addBus(Bus bus);
	public Boolean updateBus(Bus bus);
	public Boolean deleteBus(Integer busId);
	public List<Ticket>getAllTicket(Integer id);
	public List<Ticket>getTicketByBus(Integer busId,String date);
	public Boolean setBusAvailability(Availability availability);
}
