package com.zaloni.shoppingkart.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaloni.shoppingkart.dao.IUserDAO;
import com.zaloni.shoppingkart.entities.User;


@Service
public class AuthenticationServiceImpl implements IAuthenticationService{

	@Autowired
	IUserDAO userDAO;
	
	public User validateRequestForLogin(String userName, String password) {
		
		User user=userDAO.fetchUserDetails(userName,password);
		if(user!=null)
		{
			return user;
		}
		else
			return null;
	}

	public boolean resgiterUser(User user) {
		
		boolean result=userDAO.regsiterUser(user);
		if(result)
		{return true;}
		return false;
	}
	

}
