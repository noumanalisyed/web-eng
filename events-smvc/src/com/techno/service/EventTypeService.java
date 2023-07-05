package com.techno.service;

import com.techno.bean.EventTypes;
import com.techno.bean.Events;

import java.util.List;

public interface EventTypeService {
	
	public void addEventType(EventTypes eventTypes);
	
	public List<EventTypes> getEventTypes();
	
	public EventTypes getEventType(int eventTypeId);
	
	public void deleteEventType(int eventTypeId);
}
