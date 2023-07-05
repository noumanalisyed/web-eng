package com.techno.dao.impl;

import com.techno.bean.Events;
import com.techno.bean.Tournaments;
import com.techno.dao.EventDao;
import com.techno.dao.TournamentDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Component
@Repository("eventDao")
public class EventDaoImpl implements EventDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addEvent(Events events) {
		sessionFactory.getCurrentSession().saveOrUpdate(events);
	}

	@Override
	public List<Events> getEvents() {
		return (List<Events>) sessionFactory.getCurrentSession().createCriteria(Events.class).list();
	}

	@Override
	public Events getEvent(int eventId) {
		return (Events) sessionFactory.getCurrentSession().get(Events.class, eventId);
	}

	@Override
	public void deleteEvent(int eventId) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Events WHERE id = "+eventId).executeUpdate();
	}

}
