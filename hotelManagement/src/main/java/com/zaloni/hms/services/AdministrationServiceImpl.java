package com.zaloni.hms.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaloni.hms.DAO.LoginDAO;
import com.zaloni.hms.entity.User;
/**
 * It's a service part of Service Facade Pattern. Suppling useful services to Administration Controller and implementing the business logic
 * @author ADRO
 *
 */


@Service
public class AdministrationServiceImpl implements AdministrationService{

	@Autowired
	private LoginDAO loginDAO;
	
	/**
	 * The method returns a User object from the database with a given login or null if not found
	 * @param login, String, login of the searched user
	 * @return, a User object from the database with a given login or null if not found
	 */
	@Transactional
	public List<User> getAllUsers() {
		return loginDAO.getAllUsers();
	}

	/**
	 * The method allows to register new user in the application
	 * @param User, user to be registered
	 */

	@Transactional
	public void registerUser(User user) {
		loginDAO.saveOrUpdateUser(user);
		
	}

	/**
	 * The method allows to delete the user with a given id
	 * @param id, id of the user to be deleted 
	 */

	@Transactional
	public void deleteUser(int id) {
		loginDAO.deleteUser(id);
		
	}

	/**
	 * The method return the User with a given id
	 * @param id, int, id of the user in the database
	 * @return, user with a given id to be returned
	 */

	@Transactional
	public User getUser(int id) {
		return loginDAO.getUser(id);
	}

}
