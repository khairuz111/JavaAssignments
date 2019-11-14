package com.zaloni.todoManagement.dao;

import java.util.List;

import com.zaloni.todoManagement.entities.Todos;

public interface ITodoDAO {

	public List<Todos> fetchTodos(int id);
	public boolean addTodoTask(Todos todo);
	public Todos fetchTodosbyId(int id);
	public boolean updateTodoTask(Todos todo);
	public boolean deleteTodo(Todos todo);
}
