package com.lavanya.gudimella.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.lavanya.gudimella.vo.Person;
import com.lavanya.gudimella.dto.PersonResponse;
import com.lavanya.gudimella.service.PersonService;

@RestController
@RequestMapping("/person/deletePerson")
public class DeletePersonController {
	
	@Autowired
	private PersonService personService;

	@RequestMapping(value="/delete", method=RequestMethod.GET)
	private ModelAndView bindDeletePerson() {
		ModelAndView modelAndView = new ModelAndView("DeletePerson");
		Person person = new Person();
		modelAndView.addObject("person", person);
		return modelAndView;
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	private ModelAndView deletePerson(@ModelAttribute("person") Person person, ModelAndView modelAndView) {
		PersonResponse personResponse = personService.getPersonById(String.valueOf(person.getP_id()));
		Person mPerson = personResponse.getPerson();
		personService.deletePerson(mPerson);
		
		modelAndView = new ModelAndView("Success");
		String result = "Person has been deleted successfully";
		modelAndView.addObject("result", result);

		return modelAndView;
	}
}
