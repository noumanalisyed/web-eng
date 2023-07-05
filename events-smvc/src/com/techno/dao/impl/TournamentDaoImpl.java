package com.techno.dao.impl;

import com.techno.bean.Tournaments;
import com.techno.dao.TournamentDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Component
@Repository("tournamentDao")
public class TournamentDaoImpl implements TournamentDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addTournament(Tournaments tournament) {
		sessionFactory.getCurrentSession().saveOrUpdate(tournament);
	}

	@Override
	public List<Tournaments> getTournaments() {
		return (List<Tournaments>) sessionFactory.getCurrentSession().createCriteria(Tournaments.class).list();
	}

	@Override
	public Tournaments getTournament(int tournamentId) {
		return (Tournaments) sessionFactory.getCurrentSession().get(Tournaments.class, tournamentId);
	}

	@Override
	public void deleteTournament(int tournamentId) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Tournaments WHERE id = "+tournamentId).executeUpdate();
	}

}
