package org.ale.thot.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.ale.thot.dao.TimeslotDao;
import org.ale.thot.domain.Day;
import org.ale.thot.domain.Timeslot;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;

public class JsonTimeslotDao implements TimeslotDao {
	
	private static final Logger LOGGER = Logger.getLogger(JsonTimeslotDao.class);
	
	@Autowired
	private ObjectMapper jsonMapper;
	private static List<Day> days;
	private String filePath;
	
	public JsonTimeslotDao(ObjectMapper mapper, String filePath) {
		this.filePath = filePath;
		this.jsonMapper = mapper;
	}	
	
	public List<Timeslot> getTimeslots(String dayName) {
		loadDaysSafely();
		for(Day day : days) {
			if (day.getShortName().equals(dayName))
				return day.getTimeslots();
		}
		return new ArrayList<Timeslot>();
	}

	public List<Day> getConferenceDays() {
		loadDaysSafely();
		return days;
	}

	private synchronized void loadDaysSafely() {
		if (days == null)
			loadDays();		
	}

	private void loadDays() {
		
		days = new ArrayList<Day>();
				
		try {			
				InputStream jsonStream = this.getClass().getClassLoader().getResourceAsStream(filePath);
				if(jsonStream != null) {
					days = jsonMapper.readValue(jsonStream, new TypeReference<List<Day>>() {});
				}
		} catch (JsonParseException e) {
			LOGGER.error("JsonParseException", e);
		} catch (IOException e) {
			LOGGER.error("IOException", e);
		}
	}
}
