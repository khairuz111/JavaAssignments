package com.zaloni.shoppingkart.service;

import com.zaloni.shoppingkart.entities.User;

public interface IAuthenticationService {
	
	
	public User validateRequestForLogin(String userName, String password);
	public boolean resgiterUser(User user);

}
