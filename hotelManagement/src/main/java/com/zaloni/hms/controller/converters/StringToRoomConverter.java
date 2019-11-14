package com.zaloni.hms.controller.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.zaloni.hms.entity.Room;
import com.zaloni.hms.services.GuestService;


/**
 * Custom class to Convert from String (representation of room) to Room object. The class is registered in Spring. 
 * @author ADRO
 *
 */
public class StringToRoomConverter implements  Converter<String,Room>{
	
	@Autowired
	GuestService guestService;
	
	/**
	 * Converts String (id of the room) to Room object
	 */

	public Room convert(String id) {
		 Room room = guestService.getRoomById(Integer.parseInt(id));
		 return room;
	}

}
