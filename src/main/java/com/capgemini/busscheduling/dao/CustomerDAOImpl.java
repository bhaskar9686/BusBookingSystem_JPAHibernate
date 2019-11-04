package com.capgemini.busscheduling.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.capgemini.busscheduling.beans.Availability;
import com.capgemini.busscheduling.beans.Feedback;
import com.capgemini.busscheduling.beans.Ticket;
import com.capgemini.busscheduling.beans.Users;

public class CustomerDAOImpl implements CustomerDAO {

	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("TestPersistence");

	@Override
	public Users registerCustomer(Users user) {
		EntityManager manager = FACTORY.createEntityManager();
		manager.getTransaction().begin();
		user.setType("customer");
		manager.persist(user);
		manager.getTransaction().commit();
		manager.close();
		return user;

	}

	@Override
	public Users loginCustomer(Integer id, String password) {
		Users user  =null;
		EntityManager manager = FACTORY.createEntityManager();
		manager.getTransaction().begin();
		TypedQuery<Users> query = manager.createQuery("FROM Users  WHERE id = :id and password = :password and type='customer'	", Users.class);
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
	public Boolean updateCustomer(Users user) {
		boolean state = false;
		try {
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			Users users = manager.find(Users.class, user.getId());
			users.setName(user.getName());
			users.setEmail(user.getEmail());
			users.setPassword(user.getPassword());
			users.setContact(user.getContact());
			manager.getTransaction().commit();
			manager.close();
			state = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	@Override
	public Boolean deleteCustomer(Integer id) {
		boolean state = false;
		try {
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			Users user = manager.find(Users.class, id);
			manager.remove(user);
			manager.getTransaction().commit();
			manager.close();
			state = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	@Override
	public Ticket bookTicket(Ticket ticket) {
		Availability availability=null;
		ticket.setBookingDateTime(new java.util.Date());
		Ticket bookedTicket=null;
		try{
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(ticket);
			TypedQuery<Availability> availQuery=manager.createQuery("from Availability  where availDate= :aDate and busId= :bId",Availability.class);

			//update num of booked ticket
			availQuery.setParameter("aDate", ticket.getJourneyDate());
			availQuery.setParameter("bId", ticket.getBusId());

			List<Availability> availList = availQuery.getResultList();
			availability = availList.get(0);
			availability.setAvailSeat(availability.getAvailSeat()-ticket.getNumOfSeats());

			manager.getTransaction().commit();
			manager.close();

			return ticket;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return bookedTicket;
	}

	@Override
	public Boolean cancelTicket(Integer bookingId, Integer id) {
		Boolean state=false;
		Ticket ticket=null;
		Availability availability=null;
		try{
			EntityManager em = FACTORY.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Ticket> query = em.createQuery("from Ticket  where id= :uid and bookingId= :bid", Ticket.class);
			TypedQuery<Availability> availQuery=em.createQuery("from Availability where availDate= :aDate and busId= :bId",Availability.class);
			query.setParameter("uid", id);
			query.setParameter("bid", bookingId);

			List<Ticket> ticketList = query.getResultList();
			if(ticketList.size()>0) {
				ticket = ticketList.get(0);
				em.remove(ticket);

				//increase num of cancelled ticket
				availQuery.setParameter("aDate", ticket.getJourneyDate());
				availQuery.setParameter("bId", ticket.getBusId());

				List<Availability> availList = availQuery.getResultList();
				availability = availList.get(0);
				availability.setAvailSeat(availability.getAvailSeat()+ticket.getNumOfSeats());
				state=true;

			}
			em.getTransaction().commit();
			em.close();

		}catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	@Override
	public Ticket getTicketInfo(Integer bookingId) {
		Ticket ticket=null;
		try{
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			TypedQuery<Ticket> query = manager.createQuery("from Ticket t where bookingId= :bid", Ticket.class);
			query.setParameter("bid", bookingId);
			List<Ticket> ticketLi = query.getResultList();
			if(ticketLi.size()>0)
				ticket = ticketLi.get(0);
			manager.getTransaction().commit();
			manager.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ticket;
	}

	@Override
	public Boolean writeFeedback(Feedback feed) {
		boolean state = false;
		try {
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(feed);
			manager.getTransaction().commit();
			manager.close();
			state = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

}
