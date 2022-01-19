package com.lavanya.gudimella.service;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lavanya.gudimella.dto.PersonResponse;
import com.lavanya.gudimella.mapper.PersonMapperUtil;
import com.lavanya.gudimella.vo.Person;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonMapperUtil personMapperUtil;
	
	public PersonResponse addPerson(Person person) {
		return personMapperUtil.addPerson(person);
	}

	@Override
	public void updatePerson(Person person) {
		personMapperUtil.updatePerson(person);
	}

	@Override
	public void deletePerson(Person person) {
		personMapperUtil.deletePerson(person);
	}

	@Override
	public PersonResponse getPersonById(String person_id) {
		return personMapperUtil.getPersonById(person_id);
	}

	@Override
	public List<Person> getAllPersons() {
		return personMapperUtil.getAllPersons();
	}
}
