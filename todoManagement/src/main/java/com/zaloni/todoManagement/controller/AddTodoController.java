package com.zaloni.todoManagement.controller;

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
import com.zaloni.todoManagement.service.IAuthenticationService;
import com.zaloni.todoManagement.service.IFetchTodoService;

@Controller
@SessionAttributes({"name","userId"}) 
public class AddTodoController {
	
	
	@Autowired
	private IFetchTodoService fetchTodoService;

	@RequestMapping(value="/addTask")
	public ModelAndView addTask(@ModelAttribute ("name") String name,@ModelAttribute ("userId") int userId,HttpServletRequest req)
	{
		ModelAndView mv=new ModelAndView();
		User user=fetchTodoService.fetchUserbyId(userId);
		if(user!=null)
		{
			Todos todos=new Todos();
			todos.setTodoTitle(req.getParameter("title"));
			todos.setTodoDescription(req.getParameter("description"));
			todos.setTodoCategory(req.getParameter("category"));
			todos.setUser(user);
			boolean result=fetchTodoService.addTodoTask(todos);
			if(result)
			{
				mv.addObject("taskAdded", "TASK SUCCESSFULLY ADDED");
				mv.setViewName("addTask");
				return mv;
			}
			else
			{
				mv.addObject("cannotAdd", "Task cannot be added");
				mv.setViewName("addTask");
				return mv;
			}
		}
		mv.addObject("cannotAdd", "Task cannot be added");
		mv.setViewName("addTask");
		return mv;
		
	}
	
	@RequestMapping(value="/update", method= RequestMethod.POST)
	public ModelAndView updateTodos(@ModelAttribute  ("userId") int userId, HttpServletRequest req)
	{
		ModelAndView mv=new ModelAndView();
		User user=fetchTodoService.fetchUserbyId(userId);
		boolean result;
		if(user!=null)
		{
			Todos todos=new Todos();
			todos.setTodoId(Integer.parseInt(req.getParameter("todoId")));
			todos.setTodoTitle(req.getParameter("todoTitle"));
			todos.setTodoDescription(req.getParameter("todoDescription"));
			todos.setTodoCategory(req.getParameter("todoCategory"));
			todos.setUser(user);
			result=fetchTodoService.updateTodoTask(todos);
			if(result)
			{
				mv.addObject("updateSuccess", "TASK SUCCESSFULLY UPDATED!!!!");
				mv.setViewName("editForm");
				return mv;
			}
			else
			{
				mv.addObject("updateError","Task Failed Update!!!!");
				return mv;
			}
		}
		else 
		{
			mv.addObject("userError", "Failed retriving USER");
			mv.setViewName("editForm");
			return mv;
		}
	}
	
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public ModelAndView deleteTodo(@ModelAttribute ("userId") int userId,HttpServletRequest req )
	{
		ModelAndView mv=new ModelAndView("redirect:/todoList");
		int todoId=Integer.parseInt(req.getParameter("todoId"));
		boolean result;
		Todos todos=fetchTodoService.fetchTodosbyTodoId(todoId);
		if(todos!=null)
		{
			result=fetchTodoService.deleteTodo(todos);
			mv.addObject("deleteSuccess", "TASK HAS BEEN SUCCESSFULLY DELETED");
			return mv;
		}
		else
		{
			mv.addObject("deleteError", "TASK WAS NOT DELETED SUCCESSFULLY");
			return mv;
		} 
		
	}
}
