package com.capgemini.busscheduling.dao;

import com.capgemini.busscheduling.beans.Users;

public interface AdminDAO {
	
	public Users adminLogin(Integer id, String password);
	public Users registerOwner( Users users);
	public Boolean deleteCustomer(Integer id);
	public Boolean deleteOwner(Integer id);
	

}
