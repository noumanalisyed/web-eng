package com.techno.controller;

import com.techno.bean.Events;
import com.techno.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@RequestMapping(value = "/saveEvent", method = RequestMethod.POST)
	public ModelAndView saveEvent(@ModelAttribute("command") Events events,
			BindingResult result) {
		eventService.addEvent(events);
		return new ModelAndView("redirect:/addEventCategory.html");
	}
	
	@RequestMapping(value = "/addEvent", method = RequestMethod.GET)
	public ModelAndView addEvent(@ModelAttribute("command")  Events events,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("events",  eventService.getEvents());
		model.put("event", new Events());
		return new ModelAndView("addEvent", model);
	}
	
	@RequestMapping(value = "/deleteEvent", method = RequestMethod.GET)
	public ModelAndView deleteEvent(@ModelAttribute("command")  Events events,
			BindingResult result) {
		eventService.deleteEvent(events.getId().intValue());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("events", eventService.getEvents());
		return new ModelAndView("addEvent", model);
	}
	
	@RequestMapping(value = "/editEvent", method = RequestMethod.GET)
	public ModelAndView editEvent(@ModelAttribute("command")  Events events,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("event",  eventService.getEvent(events.getId().intValue()));
		model.put("events",  eventService.getEvents());
		return new ModelAndView("addEvent", model);
	}
	
	@RequestMapping(value="/events", method = RequestMethod.GET)
	public List<Events> getEvents() {
		return eventService.getEvents();
	}
}
