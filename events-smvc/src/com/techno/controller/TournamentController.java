package com.techno.controller;

import com.techno.bean.Tournaments;
import com.techno.service.TournamentService;
import com.techno.service.TournamentTypeService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TournamentController {
	
	@Autowired
	private TournamentService tournamentService;
	@Autowired
	private TournamentTypeService tournamentTypeService;
	
	@RequestMapping(value = "/saveTournament", method = RequestMethod.POST)
	public ModelAndView saveTournament(@ModelAttribute("command") Tournaments tournament,
								  BindingResult result) {
		if(tournament == null) {
			tournament.setCreatedAt(new Date());
			tournament.setEndDate(new Date());
			tournament.setStartDate(new Date());
			tournament.setUpdatedAt(new Date());
			tournament.setStatus(1);
			tournament.setActivated(1);
		}
		else
			System.out.println("Tournament Obj is Not NULL !!!!!");

		tournamentService.addTournament(tournament);
		return new ModelAndView("redirect:/addTournament.html");
	}
	
	@RequestMapping(value = "/addTournament", method = RequestMethod.GET)
	public ModelAndView addTournament(@ModelAttribute("command")  Tournaments tournament,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("tournaments",  tournamentService.getTournaments());
		model.put("tournamentTypes",  tournamentTypeService.getTournamentTypes());
		tournament.setCreatedAt(new Date());
		tournament.setEndDate(new Date());
		tournament.setUpdatedAt(new Date());
		tournament.setStartDate(new Date());

		return new ModelAndView("addTournament", model);
	}
	
	@RequestMapping(value = "/deleteTournament", method = RequestMethod.GET)
	public ModelAndView deleteTournament(@ModelAttribute("command")  Tournaments tournaments,
			BindingResult result) {
		tournamentService.deleteTournament(tournaments.getId().intValue());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("tournaments", tournamentService.getTournaments());
		return new ModelAndView("addTournament", model);
	}
	
	@RequestMapping(value = "/editTournament", method = RequestMethod.GET)
	public ModelAndView editTournament(@ModelAttribute("command")  Tournaments tournaments,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("tournament",  tournamentService.getTournament(tournaments.getId().intValue()));
		model.put("tournaments",  tournamentService.getTournaments());
		return new ModelAndView("addTournament", model);
	}
	
	@RequestMapping(value="/tournaments", method = RequestMethod.GET)
	public List<Tournaments> getTournaments() {
		return tournamentService.getTournaments();
	}
}
