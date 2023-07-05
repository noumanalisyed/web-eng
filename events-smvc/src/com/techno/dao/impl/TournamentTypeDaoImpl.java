package com.techno.dao.impl;

import com.techno.bean.TournamentTypes;
import com.techno.bean.Tournaments;
import com.techno.dao.TournamentTypeDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Component
@Repository("tournamentTypeDao")
public class TournamentTypeDaoImpl implements TournamentTypeDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addTournamentType(TournamentTypes tournamentTypes) {
		sessionFactory.getCurrentSession().saveOrUpdate(tournamentTypes);
	}

	@Override
	public List<TournamentTypes> getTournamentTypes() {
		return (List<TournamentTypes>) sessionFactory.getCurrentSession().createCriteria(TournamentTypes.class).list();
	}

	@Override
	public TournamentTypes getTournamentTypes(int tournamentTypeId) {
		return (TournamentTypes) sessionFactory.getCurrentSession().get(TournamentTypes.class, tournamentTypeId);
	}

	@Override
	public void deleteTournamentType(int tournamentTypeId) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM TournamentTypes WHERE id = "+tournamentTypeId).executeUpdate();
	}



}
