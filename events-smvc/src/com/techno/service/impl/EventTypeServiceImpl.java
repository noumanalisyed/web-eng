package com.techno.service.impl;

import com.techno.bean.EventTypes;
import com.techno.bean.Events;
import com.techno.dao.EventDao;
import com.techno.dao.EventTypeDao;
import com.techno.service.EventService;
import com.techno.service.EventTypeService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Data
@Service("eventTypeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EventTypeServiceImpl implements EventTypeService {

	@Autowired
	private EventTypeDao eventTypeDao;

	@Override
	public void addEventType(EventTypes eventTypes) {
		eventTypeDao.addEventType(eventTypes);
	}

	@Override
	public List<EventTypes> getEventTypes() {
		return eventTypeDao.getEventTypes();
	}

	@Override
	public EventTypes getEventType(int eventTypeId) {
		return eventTypeDao.getEventType(eventTypeId);
	}

	@Override
	public void deleteEventType(int eventTypeId) {
		eventTypeDao.deleteEventType(eventTypeId);
	}
}
