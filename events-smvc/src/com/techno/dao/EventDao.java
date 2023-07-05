package com.techno.dao;

import com.techno.bean.Events;
import com.techno.bean.Tournaments;

import java.util.List;

public interface EventDao {
	
	public void addEvent(Events events);
	
	public List<Events> getEvents();
	
	public Events getEvent(int eventId);
	
	public void deleteEvent(int tournamentId);
}
