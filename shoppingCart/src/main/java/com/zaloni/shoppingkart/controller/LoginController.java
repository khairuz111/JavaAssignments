package com.zaloni.shoppingkart.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.zaloni.shoppingkart.entities.Product;
import com.zaloni.shoppingkart.entities.User;
import com.zaloni.shoppingkart.service.IAuthenticationService;
import com.zaloni.shoppingkart.service.IFetchDetailService;


@Controller
@SessionAttributes({"name","userId"}) 
public class LoginController {
	
	@Autowired
	private IAuthenticationService authenticationService;
	
	@Autowired IFetchDetailService fetchDetailService; 
	
	private String username;
	private String password;
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView login(Model model,HttpServletRequest request)
	{
		
		ModelAndView mv = new ModelAndView("redirect:/allProducts");
		username=request.getParameter("username");
		password=request.getParameter("password");
		User user=authenticationService.validateRequestForLogin(username, password);
		if(user!=null)
		{
			mv.addObject("name", user.getName());
			mv.addObject("userId", user.getUserId());
			return mv;
		}	
		else
		{
			mv.addObject("errorMessage", "Invalid credentials, Re-enter Details");
			mv.setViewName("index");
			return mv;
		}
	}

	@RequestMapping(value="/adminLogin", method=RequestMethod.POST)
	public ModelAndView validateAdminLogin(Model model, HttpServletRequest request)
	{
		ModelAndView mv= new  ModelAndView("redirect:/adminHome");
		User  user=authenticationService.validateRequestForLogin(request.getParameter("username"), request.getParameter("password"));
		if(user!=null)
		{
			if(!(user.getUsername().equalsIgnoreCase("khairuz")))
			{
				mv.addObject("errorMessage", request.getParameter("username")+"  is not a admin user, Kindly login with admin credentials");
				mv.setViewName("adminLoginPage");
				return mv;
			} 
			else
			{ 
				mv.addObject("name", user.getName());
				mv.addObject("userId", user.getUserId());
				return mv;
			}
		}
		else
		{
			mv.addObject("erroMessage2","Invalid  credentials");
			return mv;
		}
		
	}
}
