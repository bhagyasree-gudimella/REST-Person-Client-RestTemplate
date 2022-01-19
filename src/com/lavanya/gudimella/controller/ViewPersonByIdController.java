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
@RequestMapping("/person")
public class ViewPersonByIdController {
	
	@Autowired
	private PersonService personService;

	@RequestMapping(value="/personById", method=RequestMethod.GET)
	private ModelAndView bindViewPersonByEmail() {
		ModelAndView modelAndView = new ModelAndView("ViewPersonById");
		Person person = new Person();
		modelAndView.addObject("personId", person);
		return modelAndView;
	}
	
	@RequestMapping(value="/personById", method=RequestMethod.POST)
	private ModelAndView viewPersonByEmail(@ModelAttribute("personId") Person person, ModelAndView modelAndView) {
		System.out.println("Person Id : " +person.getP_id());
		
		PersonResponse personResponse = personService.getPersonById(String.valueOf(person.getP_id()));
		Person mPerson = personResponse.getPerson();
		
		System.out.println(mPerson.getFirst_name());
		
		modelAndView = new ModelAndView("ViewPerson");
		modelAndView.addObject("mPerson", mPerson);
		
		return modelAndView;
	}
}
