package com.techno.controller;

import com.techno.bean.TournamentTypes;
import com.techno.bean.Tournaments;
import com.techno.service.TournamentService;
import com.techno.service.TournamentTypeService;
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
public class TournamentTypeController {
	@Autowired
	TournamentTypeService tournamentTypeService;
	
	@RequestMapping(value = "/saveTournamentType", method = RequestMethod.POST)
	public ModelAndView saveTournamentType(@ModelAttribute("command") TournamentTypes tournamentTypes,
								  BindingResult result) {
		/*Locale locale = new Locale("us", "US");
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
		String createdAt = dateFormat.format(new Date());
		String updatedAt = dateFormat.format(new Date());*/
		//System.out.print(createdAt);
		Date createdAt =  new Date();
		Date updatedAt = new Date();

		tournamentTypes.setCreatedAt(createdAt);
		tournamentTypes.setUpdatedAt(updatedAt);
		tournamentTypeService.addTournamentType(tournamentTypes);
		return new ModelAndView("redirect:/addTournamentType.html");
	}
	
	@RequestMapping(value = "/addTournamentType", method = RequestMethod.GET)
	public ModelAndView addTournamentType(@ModelAttribute("command")  TournamentTypes tournamentTypes,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("tournamentTypes",  tournamentTypeService.getTournamentTypes());
		model.put("tournamentType", new TournamentTypes());
		return new ModelAndView("addTournamentType", model);
	}
	
	@RequestMapping(value = "/deleteTournamentType", method = RequestMethod.GET)
	public ModelAndView deleteTournamentType(@ModelAttribute("command")  TournamentTypes tournamentTypes,
			BindingResult result) {
		tournamentTypeService.deleteTournamentType(tournamentTypes.getId().intValue());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("tournamentTypes", tournamentTypeService.getTournamentTypes());
		return new ModelAndView("addTournamentType", model);
	}
	
	@RequestMapping(value = "/editTournamentType", method = RequestMethod.GET)
	public ModelAndView editTournamentType(@ModelAttribute("command") TournamentTypes tournamentTypes,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("tournamentType",  tournamentTypeService.getTournamentTypes(tournamentTypes.getId().intValue()));
		model.put("tournamentTypes",  tournamentTypeService.getTournamentTypes());
		return new ModelAndView("addTournamentType", model);
	}
	
	@RequestMapping(value="/tournamentTypes", method = RequestMethod.GET)
	public List<TournamentTypes> getTournamentTypes() {
		return tournamentTypeService.getTournamentTypes();
	}
}
