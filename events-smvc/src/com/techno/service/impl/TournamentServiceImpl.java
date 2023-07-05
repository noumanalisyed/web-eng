package com.techno.service.impl;

import com.techno.bean.Events;
import com.techno.bean.Tournaments;
import com.techno.dao.EventDao;
import com.techno.dao.TournamentDao;
import com.techno.service.EventService;
import com.techno.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("tournamentServiceImpl")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TournamentServiceImpl implements TournamentService {

	@Autowired
	private TournamentDao tournamentDao;


	@Override
	public void addTournament(Tournaments tournaments) {
		tournamentDao.addTournament(tournaments);
	}

	@Override
	public List<Tournaments> getTournaments() {
		return tournamentDao.getTournaments();
	}

	@Override
	public Tournaments getTournament(int tournamentId) {
		return tournamentDao.getTournament(tournamentId);
	}

	@Override
	public void deleteTournament(int tournamentId) {
		tournamentDao.deleteTournament(tournamentId);
	}
}
