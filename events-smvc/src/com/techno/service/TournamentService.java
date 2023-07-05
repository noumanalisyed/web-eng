package com.techno.service;

import com.techno.bean.Tournaments;

import java.util.List;

public interface TournamentService {
	
	public void addTournament(Tournaments tournaments);
	
	public List<Tournaments> getTournaments();
	
	public Tournaments getTournament(int tournamentId);
	
	public void deleteTournament(int tournamentId);
}
