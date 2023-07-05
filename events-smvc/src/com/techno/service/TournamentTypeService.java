package com.techno.service;

import com.techno.bean.TournamentTypes;

import java.util.List;

public interface TournamentTypeService {
	
	public void addTournamentType(TournamentTypes tournamentTypes);
	
	public List<TournamentTypes> getTournamentTypes();
	
	public TournamentTypes getTournamentTypes(int tournamentTypeId);
	
	public void deleteTournamentType(int tournamentTypeId);
}
