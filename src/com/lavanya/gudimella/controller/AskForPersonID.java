 package com.lavanya.gudimella.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.lavanya.gudimella.vo.Person;

@RestController
@RequestMapping("/person/PersonIDInfo")
@SessionAttributes("personId")
public class AskForPersonID {

	@RequestMapping(value="/askForID", method=RequestMethod.GET)
	private ModelAndView bindAskEmail() {
		ModelAndView modelAndView = new ModelAndView("ViewPersonById");
		Person person = new Person();
		modelAndView.addObject("personId", person);
		return modelAndView;
	}
	
	@RequestMapping(value="/askForID", method=RequestMethod.POST)
	private ModelAndView updatePersonByEmail(@ModelAttribute("personId") Person person, ModelAndView modelAndView) {
		modelAndView  = new ModelAndView("redirect:/person/update/updatePerson");
		return modelAndView;
	}
}
