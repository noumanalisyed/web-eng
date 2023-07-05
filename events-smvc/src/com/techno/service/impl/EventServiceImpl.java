package com.techno.service.impl;

import com.techno.bean.Events;
import com.techno.dao.EventDao;
import com.techno.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("eventService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EventServiceImpl implements EventService {
	@Override
	public void addEvent(Events events) {
		eventDao.addEvent(events);
	}

	@Override
	public List<Events> getEvents() {
		return eventDao.getEvents();
	}

	@Override
	public Events getEvent(int eventId) {
		return eventDao.getEvent(eventId);
	}

	@Override
	public void deleteEvent(int eventId) {
		eventDao.deleteEvent(eventId);
	}

	@Autowired
	private EventDao eventDao;


}
