package com.techno.dao;

import com.techno.bean.Tournaments;

import java.util.List;

public interface TournamentDao {
	
	public void addTournament(Tournaments tournaments);
	
	public List<Tournaments> getTournaments();
	
	public Tournaments getTournament(int tournamentId);
	
	public void deleteTournament(int tournamentId);
}
