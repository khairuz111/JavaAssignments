package com.zaloni.todoManagement.service;

import java.util.List;

import com.zaloni.todoManagement.entities.Todos;
import com.zaloni.todoManagement.entities.User;

public interface IFetchTodoService {
	
	public List<Todos> fetchTodos(User user);
	public User fetchUserbyId(int userId);
	public User fetchUserAllDetails(int userId);
	public boolean addTodoTask(Todos todos);
	public Todos fetchTodosbyTodoId(int id);
	public boolean updateTodoTask(Todos todos);
	public boolean deleteTodo(Todos todos);
}
