package com.zaloni.todoManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaloni.todoManagement.dao.IUserDAO;
import com.zaloni.todoManagement.entities.User;

@Service
public class AuthenticationService implements IAuthenticationService{
	
	@Autowired
	IUserDAO userDAO;

	public User authenticateUser(String username, String password) {
		User user=userDAO.fetchUserDetails(username, password);
		if(user!=null)
		{
			return user;
		}
		return null;
	}

	public boolean resgiterUser(User user) {
		
		boolean result=userDAO.regsiterUser(user);
		if(result)
		{return true;}
		return false;
	}
}
