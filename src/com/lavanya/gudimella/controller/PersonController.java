package com.lavanya.gudimella.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lavanya.gudimella.dto.PersonResponse;
import com.lavanya.gudimella.service.PersonService;
import com.lavanya.gudimella.vo.Person;

@RestController
@RequestMapping("/testPerson")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@PostMapping("/addPerson")
	public PersonResponse addPerson(@RequestBody Person person) {
		return personService.addPerson(person);
	}
	
	@GetMapping("/persons")
	public List<Person> getAllPersons() {
		return personService.getAllPersons();
	}
	
	@GetMapping("/{person_id}")
	public PersonResponse getpersonById(@PathVariable String person_id) {
		return personService.getPersonById(person_id);
	}
	
	@PutMapping("/updatePerson")
	public void updatePerson(@RequestBody Person person) {
		personService.updatePerson(person);
	}
	
	@DeleteMapping("/deletePerson")
	public void deletePerson(Person person) {
		personService.deletePerson(person);
	}
}
