package com.techno.service.impl;

import com.techno.bean.EventTypes;
import com.techno.bean.Events;
import com.techno.bean.TournamentTypes;
import com.techno.dao.EventTypeDao;
import com.techno.dao.TournamentTypeDao;
import com.techno.service.EventTypeService;
import com.techno.service.TournamentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("tournamentTypeServiceImpl")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TournamentTypeServiceImpl implements TournamentTypeService {

	@Autowired
	TournamentTypeDao tournamentTypeDao;

	@Override
	public void addTournamentType(TournamentTypes tournamentTypes) {
		tournamentTypeDao.addTournamentType(tournamentTypes);
	}

	@Override
	public List<TournamentTypes> getTournamentTypes() {
		return tournamentTypeDao.getTournamentTypes();
	}

	@Override
	public TournamentTypes getTournamentTypes(int tournamentTypeId) {
		return tournamentTypeDao.getTournamentTypes(tournamentTypeId);
	}

	@Override
	public void deleteTournamentType(int tournamentTypeId) {
		tournamentTypeDao.deleteTournamentType(tournamentTypeId);
	}
}
