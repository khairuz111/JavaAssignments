package com.zaloni.hms.services;

import java.util.List;

import com.zaloni.hms.entity.Guest;
import com.zaloni.hms.entity.Room;

/**
 * It's a service part of Service Facade Pattern. Suppling useful services to Guest Controller and implementing the business logic
 * @author ADRO
 *
 */

public interface HotelStatusService {
	
	public List<Room> getAllRooms();
	public List<Guest> getActualGuests();
}
