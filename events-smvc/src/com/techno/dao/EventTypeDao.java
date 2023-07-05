package com.techno.dao;

import com.techno.bean.EventTypes;
import com.techno.bean.Events;

import java.util.List;

public interface EventTypeDao {
	
	public void addEventType(EventTypes eventTypes);
	
	public List<EventTypes> getEventTypes();
	
	public EventTypes getEventType(int eventTypeId);
	
	public void deleteEventType(int eventTypeId);
}
