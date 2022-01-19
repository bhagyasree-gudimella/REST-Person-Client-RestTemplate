package com.lavanya.gudimella.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import com.lavanya.gudimella.vo.Person;

@RestController
@RequestMapping("/person/contactInfo")
public class ContactInfoController {
	
	@RequestMapping(value="/addContactInfo", method=RequestMethod.GET)
	private ModelAndView bindContactInfo() {
		ModelAndView modelAndView = new ModelAndView("ContactInfo");
		Person person = new Person();
		modelAndView.addObject("person", person);
		return modelAndView;
	}
	
	@RequestMapping(value="/addContactInfo", method=RequestMethod.POST)
	private ModelAndView addContactInfo(@SessionAttribute("person") Person mPerson, @ModelAttribute("person") Person person, ModelAndView modelAndView) {
		System.out.println("Address : " +person.getAddress());
		System.out.println("First name : " +mPerson.getFirst_name());
	
		mPerson.setAddress(person.getAddress());
		mPerson.setCity(person.getCity());
		mPerson.setState(person.getState());
		mPerson.setCountry(person.getCountry());
		mPerson.setZipcode(person.getZipcode());
		mPerson.setPhone_number(person.getPhone_number());
		
		modelAndView = new ModelAndView("redirect:/person/bankInfo/addBankInfo");
		return modelAndView;
	}
}
