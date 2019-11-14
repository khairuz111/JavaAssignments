package com.zaloni.todoManagement.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.zaloni.todoManagement.entities.User;
import com.zaloni.todoManagement.service.IAuthenticationService;

@Controller
@SessionAttributes({"name","userId"}) 
public class LoginController {
	
	@Autowired 
	private IAuthenticationService authenticationService;
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView validateUser(HttpServletRequest req)
	{

		ModelAndView mv = new ModelAndView("redirect:/todoList");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		User user=authenticationService.authenticateUser(username, password);
		if(user!=null)
		{
			mv.addObject("name", user.getName());
			mv.addObject("userId",user.getUserId());
			return mv;
		}
		else
		{
			mv.addObject("errorMessage", "InvalidCreadentials");
			return mv;
		}
		
	}
	

}
