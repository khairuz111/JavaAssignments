package com.zaloni.todoManagement.service;

import org.springframework.web.servlet.ModelAndView;

import com.zaloni.todoManagement.entities.User;


public interface IAuthenticationService {

	public User authenticateUser(String username,String password );

	public boolean resgiterUser(User user);
}
