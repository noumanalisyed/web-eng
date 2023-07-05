package com.techno.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.techno.bean.PublicationBean;
import com.techno.service.CategoryService;
import com.techno.service.PublicationService;

@Controller
public class PublicationController {
	
	@Autowired
	private PublicationService publicationService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/savePublication", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("command") PublicationBean publication, 
			BindingResult result) {
		publicationService.addPublication(publication);
		return new ModelAndView("redirect:/addPublication.html");
	}
	
	@RequestMapping(value = "/addPublication", method = RequestMethod.GET)
	public ModelAndView addPublication(@ModelAttribute("command")  PublicationBean publication,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("publications",  publicationService.getPublications());
		model.put("categories",  categoryService.getCategories());
		return new ModelAndView("addPublication", model);
	}
	
	@RequestMapping(value = "/deletePublication", method = RequestMethod.GET)
	public ModelAndView deletePublication(@ModelAttribute("command")  PublicationBean publication,
			BindingResult result) {
		publicationService.deletePublication(publication.getPubId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("publications",  publicationService.getPublications());
		model.put("categories",  categoryService.getCategories());
		return new ModelAndView("addPublication", model);
	}
	
	@RequestMapping(value = "/editPublication", method = RequestMethod.GET)
	public ModelAndView editPublication(@ModelAttribute("command")  PublicationBean publication,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("publication",  publicationService.getPublication(publication.getPubId()));
		model.put("publications",  publicationService.getPublications());
		model.put("categories",  categoryService.getCategories());
		return new ModelAndView("addPublication", model);
	}
	
	@RequestMapping(value="/publications", method = RequestMethod.GET)
	public List<PublicationBean> getPublications() {
		return publicationService.getPublications();
	}
}
