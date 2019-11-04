package com.capgemini.busscheduling.services;

import java.util.List;

import com.capgemini.busscheduling.beans.Availability;
import com.capgemini.busscheduling.beans.Bus;
import com.capgemini.busscheduling.beans.Ticket;
import com.capgemini.busscheduling.beans.Users;
import com.capgemini.busscheduling.dao.OwnerDAO;
import com.capgemini.busscheduling.dao.OwnerDAOImpl;

public class OwnerServiceImpl implements OwnerService {
	
	OwnerDAO dao = new OwnerDAOImpl();
	
	@Override
	public Users loginOwner(Integer id, String password) {
		return dao.loginOwner(id, password);
	}

	@Override
	public Bus addBus(Bus bus) {
		return dao.addBus(bus);
	}

	@Override
	public Boolean updateBus(Bus bus) {
		return dao.updateBus(bus);
	}

	@Override
	public Boolean deleteBus(Integer busId) {
		return dao.deleteBus(busId);
	}

	@Override
	public List<Ticket> getTicketByBus(Integer busId, String date) {
		return dao.getTicketByBus(busId, date);
	}

	@Override
	public List<Ticket> getAllTicket(Integer id) {
		return dao.getAllTicket(id);
	}

	@Override
	public Boolean setBusAvailability(Availability availability) {
		return dao.setBusAvailability(availability);
	}

}
