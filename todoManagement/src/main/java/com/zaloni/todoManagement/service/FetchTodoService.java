package com.zaloni.todoManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaloni.todoManagement.dao.ITodoDAO;
import com.zaloni.todoManagement.dao.IUserDAO;
import com.zaloni.todoManagement.entities.Todos;
import com.zaloni.todoManagement.entities.User;
  
@Service
public class FetchTodoService implements IFetchTodoService{
	
	@Autowired
	private ITodoDAO todoDAO;
	
	@Autowired
	private IUserDAO  userDAO;

	public User fetchUserbyId(int userId) {
		User user=userDAO.fetchUserbyId(userId);
		if(user!=null)
		{return user;}
		return null;
	}



	public boolean addTodoTask(Todos todos) {
		boolean result=todoDAO.addTodoTask(todos);
		if(result)
		{
			return true;
		}
		return false;
	}



	public List<Todos> fetchTodos(User user) {
		// TODO Auto-generated method stub
		return null;
	}



	public User fetchUserAllDetails(int userId) {
		User user=userDAO.fetchUserAllDetails(userId);
		if(user!=null)
			return user;
		return null;
	}



	public Todos fetchTodosbyTodoId(int id) {
		
		Todos todos=todoDAO.fetchTodosbyId(id);
		if(todos!=null)
			return todos;
		
		return null;
	}



	public boolean updateTodoTask(Todos todos) {
		boolean result=todoDAO.updateTodoTask(todos);
		if(result)
			return true;
		return false;
	}



	public boolean deleteTodo(Todos todos) {

		boolean result=todoDAO.deleteTodo(todos);
		if(result)
			return true;
		return false;
	}

}
