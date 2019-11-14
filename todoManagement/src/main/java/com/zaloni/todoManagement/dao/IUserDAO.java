package com.zaloni.todoManagement.dao;

import com.zaloni.todoManagement.entities.User;

public interface IUserDAO {
	

	public User fetchUserDetails(String name,String password);

	public boolean regsiterUser(User user);
	public User fetchUserbyId(int userId);
	public User fetchUserAllDetails(int userId);
	

}
