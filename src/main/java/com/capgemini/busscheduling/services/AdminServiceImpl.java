package com.capgemini.busscheduling.services;


import com.capgemini.busscheduling.beans.Users;
import com.capgemini.busscheduling.dao.AdminDAO;
import com.capgemini.busscheduling.dao.AdminDAOImpl;

public class AdminServiceImpl implements AdminService {

	AdminDAO dao = new AdminDAOImpl();
	@Override
	public Users adminLogin(Integer id, String password) {
		return dao.adminLogin(id, password);
	}

	@Override
	public Users registerOwner(Users user) {
		return dao.registerOwner(user);
	}

	@Override
	public Boolean deleteCustomer(Integer id) {
		return dao.deleteCustomer(id);
	}

	@Override
	public Boolean deleteOwner(Integer id) {
		return dao.deleteCustomer(id);
	}

}
