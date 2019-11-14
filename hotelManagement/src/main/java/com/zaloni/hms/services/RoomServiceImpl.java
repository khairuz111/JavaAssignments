package com.zaloni.hms.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaloni.hms.DAO.RoomDAO;
import com.zaloni.hms.entity.Room;

/**
 * It's a service part of Service Facade Pattern. Suppling useful services to Room Controller and implementing the business logic
 * @author ADRO
 *
 */

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomDAO roomDAO;
	
	/**
	 * @see RoomDAO
	 */
	@Transactional
	public Room getRoomById(int id) {
		return roomDAO.getRoomById(id);
	}

	/**
	 * @see RoomDAO
	 */

	@Transactional
	public List<Room> getVacantRooms() {
		return roomDAO.getVacantRooms();
	}

	/**
	 * @see RoomDAO
	 */

	@Transactional
	public List<Room> getOccupiedRooms() {
		return roomDAO.getOccupiedRooms();
	}

	/**
	 * @see RoomDAO
	 */

	@Transactional
	public void saveUpdateRoom(Room theRoom) {
		roomDAO.saveUpdateRoom(theRoom);
		
	}

}
