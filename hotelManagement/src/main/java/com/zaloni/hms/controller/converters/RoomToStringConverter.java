package com.zaloni.hms.controller.converters;

import org.springframework.core.convert.converter.Converter;

import com.zaloni.hms.entity.Room;

/**
 * Custom Converter class to convert from Room class to String representation. The class is registered in Spring. 
 * @author ADRO
 *
 */

public class RoomToStringConverter  implements  Converter<Room,String>{

	/**
	 * Method converts a String to Room
	 */

	public String convert(Room room) {
		return String.valueOf(room.getStandard() + " " + room.getNumber());
	}

}
