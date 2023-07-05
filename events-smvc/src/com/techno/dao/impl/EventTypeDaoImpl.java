package com.techno.dao.impl;

import com.techno.bean.EventTypes;
import com.techno.bean.Events;
import com.techno.dao.EventDao;
import com.techno.dao.EventTypeDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository("eventTypeDao")
public class EventTypeDaoImpl implements EventTypeDao {

	@Override
	public void addEventType(EventTypes eventTypes) {
		sessionFactory.getCurrentSession().saveOrUpdate(eventTypes);
	}

	@Override
	public List<EventTypes> getEventTypes() {
		return (List<EventTypes>) sessionFactory.getCurrentSession().createCriteria(EventTypes.class).list();
	}

	@Override
	public EventTypes getEventType(int eventTypeId) {
		return (EventTypes) sessionFactory.getCurrentSession().get(EventTypes.class, eventTypeId);
	}

	@Override
	public void deleteEventType(int eventTypeId) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM EventTypes WHERE id = "+eventTypeId).executeUpdate();
	}

	@Autowired
	private SessionFactory sessionFactory;

}
