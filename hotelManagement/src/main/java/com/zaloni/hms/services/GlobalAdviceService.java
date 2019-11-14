package com.zaloni.hms.services;

import java.util.List;

import com.zaloni.hms.entity.ToDo;

/**
 * It's a service part of Service Facade Pattern. Suppling useful services to GlobalAdvice Controller and implementing the business logic
 * @author ADRO
 *
 */

public interface GlobalAdviceService {
	
	/**
	 * The method allows to add a new To Do action to the list
	 * @param ToDo, the action to be added to the list
	 */
	public void addToDo(ToDo toDo);
	
	/**
	 * The method allows to get the To Do action list
	 */
	public List<ToDo> getToDo();
}
