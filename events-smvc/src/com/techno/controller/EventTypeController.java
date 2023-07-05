package com.techno.controller;

import com.techno.bean.EventTypes;
import com.techno.bean.Events;
import com.techno.service.EventService;
import com.techno.service.EventTypeService;
import lombok.Data;
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

@Data
@Controller
public class EventTypeController {

	@Autowired
	private EventTypeService eventTypeService;
	
	@RequestMapping(value = "/saveEventType", method = RequestMethod.POST)
	public ModelAndView saveEventType(@ModelAttribute("command") EventTypes eventTypes,
			BindingResult result) {
		eventTypeService.addEventType(eventTypes);
		return new ModelAndView("redirect:/addEventType.html");
	}
	
	@RequestMapping(value = "/addEventType", method = RequestMethod.GET)
	public ModelAndView addEventType(@ModelAttribute("command")  EventTypes eventTypes,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("eventType",new EventTypes());
		model.put("eventTypes",  eventTypeService.getEventTypes());
		return new ModelAndView("addEventType", model);
	}
	
	@RequestMapping(value = "/deleteEventType", method = RequestMethod.GET)
	public ModelAndView deleteEventType(@ModelAttribute("command")  EventTypes eventTypes,
			BindingResult result) {
		eventTypeService.deleteEventType(eventTypes.getId().intValue());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("eventTypes", eventTypeService.getEventTypes());
		return new ModelAndView("addEventType", model);
	}
	
	@RequestMapping(value = "/editEventType", method = RequestMethod.GET)
	public ModelAndView editEventType(@ModelAttribute("command")  EventTypes eventTypes,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("event", eventTypeService.getEventType(eventTypes.getId().intValue()));
		model.put("events",  eventTypeService.getEventTypes());
		return new ModelAndView("addEventType", model);
	}
	
	@RequestMapping(value="/eventTypes", method = RequestMethod.GET)
	public List<EventTypes> getEventTypes() {
		return eventTypeService.getEventTypes();
	}
}
