package com.zaloni.hms.services;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaloni.hms.DAO.GuestDAO;
import com.zaloni.hms.DAO.RoomDAO;
import com.zaloni.hms.entity.Guest;
import com.zaloni.hms.entity.Room;

/**
 * It's a service part of Service Facade Pattern. Suppling useful services to Guest Controller and implementing the business logic
 * @author ADRO
 *
 */

@Service
public class HotelStatusServiceImpl implements HotelStatusService{
	
	@Autowired
	private RoomDAO roomDAO; 
	
	@Autowired
	private GuestDAO guestDAO;
	
	/**
	 * @see RoomDAO
	 */
	@Transactional
	public List<Room> getAllRooms() {
		return roomDAO.getAllRooms();
	}
	
	/**
	 * @see GuestDAO
	 */

	@Transactional
	public List<Guest> getActualGuests() {
		return guestDAO.getActualGuests();
	}

}
