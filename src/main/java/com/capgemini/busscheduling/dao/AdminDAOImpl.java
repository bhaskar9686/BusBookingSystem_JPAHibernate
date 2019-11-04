package com.capgemini.busscheduling.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.capgemini.busscheduling.beans.Users;

public class AdminDAOImpl implements AdminDAO {

	static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("TestPersistence");

	@Override
	public Users adminLogin(Integer id, String password) {
		
		Users user =null;
		EntityManager manager = FACTORY.createEntityManager();
		manager.getTransaction().begin();
		TypedQuery<Users> 	query = manager.createQuery("FROM Users WHERE id = :aid and password = :apassword and type='admin'", Users.class);
		query.setParameter("aid", id);
		query.setParameter("apassword", password);
		List<Users> users = query.getResultList();
		if(users.size() > 0) {
			user = users.get(0);
			manager.getTransaction().commit();
			manager.close();
		}
		return user;
	}
	@Override
	public Users registerOwner(Users user) {
		EntityManager manager = FACTORY.createEntityManager();
		manager.getTransaction().begin();
		user.setType("owner");
		manager.persist(user);
		manager.getTransaction().commit();
		manager.close();
		return user;
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
	public Boolean deleteOwner(Integer id) {
		boolean state = false;
		try {
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			Users user  = manager.find(Users.class, id);
			manager.remove(user);
			manager.getTransaction().commit();
			manager.close();
			state = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}


}
