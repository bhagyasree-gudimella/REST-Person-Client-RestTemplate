package com.lavanya.gudimella.service;

import java.util.List;

import com.lavanya.gudimella.dto.PersonResponse;
import com.lavanya.gudimella.vo.Person;

public interface PersonService {
	
	public PersonResponse addPerson(Person person);
	
	public List<Person> getAllPersons();
	
	public void updatePerson(Person person);
	
	public void deletePerson(Person person);
	
	public PersonResponse getPersonById(String person_id);
}
