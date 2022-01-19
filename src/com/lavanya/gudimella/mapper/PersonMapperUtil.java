package com.lavanya.gudimella.mapper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lavanya.gudimella.dto.PersonResponse;
import com.lavanya.gudimella.vo.Person;

@Component
@PropertySource(value="classpath:application.properties")
public class PersonMapperUtil {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Environment environment; 
	
	@PostConstruct
	public HttpHeaders getHttpHeaders() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return httpHeaders;
	}
	
	@PostConstruct
	public ObjectMapper getObjectMapper() {
		ObjectMapper objMapper = new ObjectMapper();
		return objMapper;
	}
	
	/**
	 * This method is to add a person using 
	 * REST API
	 * @param person
	 * @return personResponse
	 */
	public PersonResponse addPerson(Person person) {
		PersonResponse personResponse = new PersonResponse();
		try {
			//convert the input Person Object to JSON string
			String jsonRequest = this.getObjectMapper().writeValueAsString(person);
			
			//for any request (post, put, get, delete) :: should communicate with REST WebService over a network, hence we need HttpEntity
			HttpEntity<String> httpEntityRequest = new HttpEntity<String>(jsonRequest, this.getHttpHeaders());
			
			//get the post url from REST WebService provider using application properties file
			String post_url = environment.getProperty("addPerson.url");
			
			//perform a POST request invoking the REST WebService over a network using RestTemplate Object and get a response back
			String result = restTemplate.postForObject(post_url, httpEntityRequest, String.class);
	
			//convert the JSON response -> result string from REST WebService to PersonResponse object 
			//also initialize it back to person response object and return it
			personResponse = this.getObjectMapper().readValue(result, PersonResponse.class);
		} catch (JsonProcessingException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return personResponse;
	}
	
	/**
	 * This method is used to get all persons 
	 * using REST API
	 */
	public List<Person> getAllPersons() {
		HttpEntity<String> httpEntityRequest = new HttpEntity<String>(this.getHttpHeaders());
		String getAllPersonsUrl = environment.getProperty("getAllPersons.url");
		ResponseEntity<Person[]> response = restTemplate.exchange(getAllPersonsUrl, HttpMethod.GET, httpEntityRequest, Person[].class);
		List<Person> personsList = Arrays.asList(response.getBody());
		return personsList;
	}
	
	/**
	 * This method is used to get the person using 
	 * REST API
	 * @param person_id
	 * @return personResponse
	 */
	public PersonResponse getPersonById(String person_id) {
		PersonResponse personResponse = new PersonResponse();
		try {
			String getPerson_url = environment.getProperty("getPersonById.url") + person_id;
			String result = restTemplate.getForObject(getPerson_url, String.class);
			personResponse = this.getObjectMapper().readValue(result, PersonResponse.class);
		} catch (JsonProcessingException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return personResponse;
	}
	
	/**
	 * This method is used to update the person
	 * using REST API
	 * @param person
	 * @return
	 */
	public void updatePerson(Person person) {
		try {
			String jsonRequest = this.getObjectMapper().writeValueAsString(person);
			HttpEntity<String>  httpEntityRequest = new HttpEntity<String>(jsonRequest, this.getHttpHeaders());
			String update_url = environment.getProperty("updatePerson.url");
			
			Map<String, String> params = new HashMap<String, String>();
			params.put("address", person.getFirst_name());
			params.put("city", person.getMiddle_name());
			params.put("state", person.getLast_name());
			params.put("country", person.getEmail_address());
			params.put("zipcode", person.getFirst_name());
			params.put("phone_number", person.getMiddle_name());
			params.put("bank_name", person.getLast_name());
			params.put("account_details", person.getEmail_address());
			params.put("p_id", String.valueOf(person.getP_id()));
			
			restTemplate.put(update_url, httpEntityRequest, params);
		} catch (JsonProcessingException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to delete the person
	 * using REST API
	 * @param person
	 * @return
	 */
	public void deletePerson(Person person) {
		String jsonRequest;
		try {
			jsonRequest = this.getObjectMapper().writeValueAsString(person);
			HttpEntity<String>  httpEntityRequest = new HttpEntity<String>(jsonRequest, this.getHttpHeaders());
			String delete_url = environment.getProperty("delete.url");
			restTemplate.exchange(delete_url, HttpMethod.DELETE, httpEntityRequest, Person.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
