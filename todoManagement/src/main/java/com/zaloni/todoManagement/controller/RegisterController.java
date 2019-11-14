package com.zaloni.todoManagement.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zaloni.todoManagement.entities.User;
import com.zaloni.todoManagement.service.IAuthenticationService;


@Controller
public class RegisterController {
	
	
	@Autowired
	private IAuthenticationService authenticationService;
	
	
	@RequestMapping(value="/register")
	public ModelAndView registerUser(HttpServletRequest req)
	{
		User user=new User();
		ModelAndView modelView=new  ModelAndView();
		user.setName(req.getParameter("fullname"));
		user.setUsername(req.getParameter("username"));
		user.setGender(req.getParameter("gender"));
		user.setAge(Integer.parseInt(req.getParameter("age")));
		user.setAddress(req.getParameter("address"));
		user.setPassword(req.getParameter("password"));
		
		
		boolean result=authenticationService.resgiterUser(user);
		if(result)
		{
			modelView.addObject("successMessage", "User Registered Successfully");
			modelView.setViewName("registration");
			return modelView;
		}
		else
		{
			modelView.addObject("errorMessage", "Resgistration Unsuccessful");
			modelView.setViewName("registration");
			return modelView;
		}
	}

}
