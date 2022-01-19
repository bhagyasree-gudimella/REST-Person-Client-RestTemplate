package com.lavanya.gudimella.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import com.lavanya.gudimella.vo.Person;
import com.lavanya.gudimella.dto.PersonResponse;
import com.lavanya.gudimella.service.PersonService;

@RestController
@RequestMapping("/person/update")
public class UpdatePersonController {
	
	@Autowired
	private PersonService personService;

	@RequestMapping(value="/updatePerson", method=RequestMethod.GET)
	private ModelAndView bindUpdateForm(@SessionAttribute("personId") Person mPerson) {
		ModelAndView modelAndView = new ModelAndView("UpdatePerson");
		Person person = new Person();
		modelAndView.addObject("person", person);
		return modelAndView;
	}
	
	@RequestMapping(value="/updatePerson", method=RequestMethod.POST)
	private ModelAndView updatePerson(@SessionAttribute("personId") Person sPerson, @ModelAttribute("person") Person person, ModelAndView modelAndView) {
		PersonResponse personResponse = personService.getPersonById(String.valueOf(sPerson.getP_id()));
		Person mPerson = personResponse.getPerson();
	
		mPerson.setAddress(person.getAddress());
		mPerson.setCity(person.getCity());
		mPerson.setState(person.getState());
		mPerson.setCountry(person.getCountry());
		mPerson.setZipcode(person.getZipcode());
		mPerson.setPhone_number(person.getPhone_number());
		mPerson.setBank_name(person.getBank_name());
		mPerson.setAccount_details(person.getAccount_details());
		
		personService.updatePerson(mPerson);
		
		modelAndView = new ModelAndView("Success");
		String result = mPerson.getP_id() +", has been updated successfully";
		modelAndView.addObject("result", result);
		
		return modelAndView;
	}
}
