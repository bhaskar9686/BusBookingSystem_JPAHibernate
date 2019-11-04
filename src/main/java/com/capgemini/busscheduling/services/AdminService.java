package com.capgemini.busscheduling.services;

import com.capgemini.busscheduling.beans.Users;

public interface AdminService {
	public Users adminLogin(Integer id, String password);
	public Users registerOwner( Users user);
	public Boolean deleteCustomer(Integer id);
	public Boolean deleteOwner(Integer id);
}
