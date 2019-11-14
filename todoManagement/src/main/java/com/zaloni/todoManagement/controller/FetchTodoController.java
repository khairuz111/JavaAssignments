package com.zaloni.todoManagement.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.zaloni.todoManagement.entities.Todos;
import com.zaloni.todoManagement.entities.User;
import com.zaloni.todoManagement.service.IFetchTodoService;

@Controller
@SessionAttributes({"name","userId"}) 
public class FetchTodoController {
	
	@Autowired
	private IFetchTodoService fetchTodoService;
	
	@RequestMapping(value="/todoList")
	public ModelAndView fetchTodoList(@ModelAttribute("userId") int userId,@ModelAttribute("name") String name)
	{
		ModelAndView mv= new ModelAndView();
		User userTodosList=fetchTodoService.fetchUserAllDetails(userId);
		if(userTodosList.getTodos()!=null)
		{
			mv.addObject("name", name);
			mv.addObject("todosList",userTodosList.getTodos());
			mv.setViewName("home");
			return mv;
		}
		else
		{
			mv.addObject("emptyList", "You HAVEN'T CREATED ANY TODO TASK");
			mv.setViewName("home");
			return mv;
		}
		
	}
	
	
	@RequestMapping(value="/profile")
	public ModelAndView FetchUserProfile(@ModelAttribute("userId") int userId)
	{
		ModelAndView mv=new ModelAndView();
		User user=fetchTodoService.fetchUserbyId(userId);
		if(user!=null)
		{
			mv.addObject("userId", user.getUserId());
			mv.addObject("name", user.getName());
			mv.addObject("username", user.getUsername());
			mv.addObject("gender", user.getGender());
			mv.addObject("age", user.getAge());
			mv.addObject("address", user.getAddress());
			mv.setViewName("profile");
			return mv;
		}
		{
			mv.addObject("profileError", "Failed to load profile data");
			mv.setViewName("profile");
			return mv;
		}
		
	}

	@RequestMapping(value="/fetchTodo", method = RequestMethod.POST)
	public ModelAndView fetchTodos(@ModelAttribute ("userId") int userId,HttpServletRequest req)
	{
		ModelAndView mv=new ModelAndView();
		Todos todos= fetchTodoService.fetchTodosbyTodoId(Integer.parseInt(req.getParameter("todoId")));
		if(todos!=null)
		{
			mv.addObject("todoId", todos.getTodoId());
			mv.addObject("todoTitle", todos.getTodoTitle());
			mv.addObject("todoDescription", todos.getTodoDescription());
			mv.addObject("todoCategory", todos.getTodoCategory());
			mv.setViewName("editForm");
			return mv;
		}
		{
			mv.addObject("error", "Cannot edit the task!!!!");
			mv.setViewName("editForm");
			return mv;
		}
	}
}
