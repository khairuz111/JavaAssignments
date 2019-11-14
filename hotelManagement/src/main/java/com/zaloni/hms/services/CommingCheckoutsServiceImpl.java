package com.zaloni.hms.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaloni.hms.DAO.GuestDAO;
import com.zaloni.hms.entity.Guest;

/**
 * It's a service part of Service Facade Pattern. Suppling useful services to CommingCheckouts Controller and implementing the business logic
 * @author ADRO
 *
 */

@Service
public class CommingCheckoutsServiceImpl implements CommingCheckoutsService {
	
	@Autowired
	private GuestDAO guestDAO;
	
	/**
	 * @see GuestDAO
	 */

	@Transactional
	public List<Guest> getCommingCheckouts() {
		
		return guestDAO.getCommingCheckouts();
	}

}
