package com.capgemini.busscheduling.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.capgemini.busscheduling.beans.Availability;
import com.capgemini.busscheduling.beans.Bus;
import com.capgemini.busscheduling.beans.Ticket;
import com.capgemini.busscheduling.beans.Users;

public class OwnerDAOImpl implements OwnerDAO {

	static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("TestPersistence");

	@Override
	public Users loginOwner(Integer id, String password) {
		Users user = null;
		EntityManager manager = FACTORY.createEntityManager();
		manager.getTransaction().begin();
		TypedQuery<Users> query = manager.createQuery("FROM Users WHERE id = :id and password = :password and type='owner'	", Users.class);
		query.setParameter("id", id);
		query.setParameter("password", password);
		List<Users> users = query.getResultList();
		if(users.size() > 0) {
			user = users.get(0);
			manager.getTransaction().commit();
			manager.close();
		}
		return user;
	}

	@Override
	public Bus addBus(Bus bus) {
		try {
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(bus);
			manager.getTransaction().commit();
			manager.close();
			return bus;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean updateBus(Bus bus) {
		Boolean state = false;
		try {
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			Bus dbus = manager.find(Bus.class, bus.getBusId());
			dbus.setBusName(bus.getBusName());
			dbus.setBusType(bus.getBusType());
			dbus.setSource(bus.getSource());
			dbus.setDestination(bus.getDestination());
			dbus.setPrice(bus.getPrice());
			dbus.setTotalSeats(bus.getTotalSeats());
			manager.getTransaction().commit();
			manager.close();
			state = true;
		} catch (Exception e) {
			//Custom Exception
			e.printStackTrace();
		}
		return state;
	}

	@Override
	public Boolean deleteBus(Integer busId) {
		Boolean state=false;
		try{
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			Bus bus = manager.find(Bus.class, busId);
			manager.remove(bus);
			manager.getTransaction().commit();
			state=true;
			manager.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return state;
	}

	@Override
	public List<Ticket> getAllTicket(Integer id) {

		List<Ticket> ticketLi=null; 
		try{
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			TypedQuery<Ticket> query = manager.createQuery("from Ticket where customerId= :id", Ticket.class);
			query.setParameter("id", id); 
			ticketLi = query.getResultList();
			manager.getTransaction().commit();
			manager.close(); 
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ticketLi;	
	}

	@Override
	public List<Ticket> getTicketByBus(Integer busId, String date) {
		List<Ticket> ticketLi=null;
		try{
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			TypedQuery<Ticket> query = manager.createQuery("from Ticket t where busId= :bid and journeyDate= :jDate", Ticket.class);
			query.setParameter("bid", busId);
			query.setParameter("jDate", date);
			ticketLi = query.getResultList();
			manager.getTransaction().commit();
			manager.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ticketLi;	
	}

	@Override
	public Boolean setBusAvailability(Availability availability) {
		Boolean state = false;
		try {
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(availability);
			manager.getTransaction().commit();
			manager.close();
			state = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}
}
