package com.lavanya.gudimella.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import com.lavanya.gudimella.vo.Person;
import com.lavanya.gudimella.service.PersonService;

@RestController
@RequestMapping("/person/bankInfo")
public class BankInfoController {

	@Autowired
	private PersonService personService;

	@RequestMapping(value = "/addBankInfo", method = RequestMethod.GET)
	private ModelAndView bindBankInfo() {
		ModelAndView modelAndView = new ModelAndView("BankInfo");
		Person person = new Person();
		modelAndView.addObject("person", person);
		return modelAndView;
	}

	@RequestMapping(value = "/addBankInfo", method = RequestMethod.POST)
	private ModelAndView addContactInfo(@SessionAttribute("person") Person mPerson,
			@ModelAttribute("person") Person person, ModelAndView modelAndView) {
		System.out.println("First name : " + mPerson.getFirst_name());
		System.out.println("Address : " + mPerson.getAddress());
		System.out.println("Bank name : " + person.getBank_name());

		// set the person details to session's person object
		mPerson.setBank_name(person.getBank_name());
		mPerson.setAccount_details(person.getAccount_details());
		mPerson.setSsn_number(person.getSsn_number());

		// save to database
		personService.addPerson(mPerson);

		// redirect to success page
		modelAndView = new ModelAndView("RegistrationSuccess");
		modelAndView.addObject("mPerson", mPerson);
		return modelAndView;
	}
}
