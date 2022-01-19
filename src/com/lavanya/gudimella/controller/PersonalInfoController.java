package com.lavanya.gudimella.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.lavanya.gudimella.vo.Person; 

@RestController
@RequestMapping("/person/personalInfo")
@SessionAttributes("person")
public class PersonalInfoController {

	@RequestMapping(value="/addPersonalInfo", method=RequestMethod.GET)
	private ModelAndView bindPersonalInfo() {
		ModelAndView modelAndView = new ModelAndView("PersonalInfo");
		Person person  = new Person();
		modelAndView.addObject("person", person);
		return modelAndView;
	}
	
	@RequestMapping(value="/addPersonalInfo", method=RequestMethod.POST)
	private ModelAndView addPersonalInfo(@ModelAttribute("person") Person person, ModelAndView modelAndView) {
		System.out.println(person.getFirst_name());
		modelAndView = new ModelAndView("redirect:/person/contactInfo/addContactInfo");		
		return modelAndView;
	}
}
