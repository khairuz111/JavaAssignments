package com.zaloni.shoppingkart.dao;


import java.util.List;

import com.zaloni.shoppingkart.entities.User;

public interface IUserDAO {
	
	public void AddUser();
	public void DeleteUser();
	public User fetchUserDetails(String name,String password);
	public User fetchUserDeatils(int id);
	public boolean regsiterUser(User user);
	public List<User> fetchAllUsers();
	public User fetchUserOrderDetail(int userId);
	

}
