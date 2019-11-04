package com.capgemini.busscheduling.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.capgemini.busscheduling.beans.Availability;
import com.capgemini.busscheduling.beans.Bus;
import com.capgemini.busscheduling.beans.Feedback;

public class BusBookingDAOImpl implements BusBookingDAO {

	static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("TestPersistence");

	@Override
	public Bus searchBus(Integer busId) {
		EntityManager manager = FACTORY.createEntityManager();
		manager.getTransaction().begin();
		Bus bus = manager.find(Bus.class, busId);
		return bus;
	}

	@Override
	public Integer checkAvailability(Integer busId, String date) {
		Integer availSeats=0;
		Availability availability=null;
		try{
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			TypedQuery<Availability> query = manager.createQuery("from Availability a where busId= :bid and availDate= :adate", Availability.class);
			query.setParameter("bid", busId);
			query.setParameter("adate", date);
			List<Availability> avaiList = query.getResultList();
			if(avaiList.size()>0) {
				availability  = avaiList.get(0);
				availSeats=availability.getAvailSeat();
			}
			manager.getTransaction().commit();
			manager.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return availSeats;
	}

	@Override
	public List<Availability> checkAvailability(String source, String destination, String date) {
		List<Availability> availList=new ArrayList<Availability>();
		List<Availability> resulList=null;
		List<Bus> busList=null;
		try{
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			TypedQuery<Bus> query = manager.createQuery("from Bus b where source= :busSource and destination= :busDestination", Bus.class);
			query.setParameter("busSource", source);
			query.setParameter("busDestination", destination);
			busList = query.getResultList();
			TypedQuery<Availability> availQuery=manager.createQuery("from Availability a where busId= :bid and availDate= :aDate",Availability.class);
			if(busList.size()>0) {
				for(Bus bus : busList) {
					availQuery.setParameter("bid", bus.getBusId());
					availQuery.setParameter("aDate", date);
					
					//get the result from table 
					resulList=availQuery.getResultList();
					
					//store the Availability in availList
					availList.addAll(resulList);
				}
			}
			manager.getTransaction().commit();
			manager.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return availList;
	}

	@Override
	public List<Feedback> viewFeedback() {
		List<Feedback> feed=null;
		try{
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			TypedQuery<Feedback> query = manager.createQuery("from Feedback ", Feedback.class);
			feed = query.getResultList();
			manager.getTransaction().commit();
			manager.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return feed;
	}

	@Override
	public List<Bus> showAllBuses() {
		List<Bus> buses=null;
		try{
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			TypedQuery<Bus> query = manager.createQuery("from Bus ", Bus.class);
			buses = query.getResultList();
			manager.getTransaction().commit();
			manager.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return buses;
	}

}
