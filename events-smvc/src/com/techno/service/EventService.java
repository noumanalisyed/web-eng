package com.techno.service;

import com.techno.bean.Events;

import java.util.List;

public interface EventService {
	
	public void addEvent(Events events);
	
	public List<Events> getEvents();
	
	public Events getEvent(int eventId);
	
	public void deleteEvent(int eventId);
}
