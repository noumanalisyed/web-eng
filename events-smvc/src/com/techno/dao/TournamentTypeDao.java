package com.techno.dao;

import com.techno.bean.TournamentTypes;

import java.util.List;

public interface TournamentTypeDao {
	
	public void addTournamentType(TournamentTypes tournamentTypes);
	
	public List<TournamentTypes> getTournamentTypes();
	
	public TournamentTypes getTournamentTypes(int tournamentTypeId);
	
	public void deleteTournamentType(int tournamentTypeId);
}
