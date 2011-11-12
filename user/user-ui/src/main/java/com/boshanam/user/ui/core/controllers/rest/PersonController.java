package com.boshanam.user.ui.core.controllers.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.boshanam.user.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Swetha
 * 
 */
@Controller
@RequestMapping("/person")
public class PersonController {

	private Set<Person> personsList = Collections
			.synchronizedSet(new HashSet<Person>());

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody
	List<Person> getAllPersons() {
		if (personsList.size() > 0) {
			return new ArrayList<Person>(personsList);
		}
		// Return a list of Person objects
		Person p = new Person();
		p.setId(2333);
		p.setName("OmSriSairam");
		personsList.add(p);
		System.out
				.println("#############################  Got it ************** ##################");
		return new ArrayList<Person>(personsList);
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public @ResponseBody
	Person updatePerson(@ModelAttribute Person person) {
		// The person object will only have the fields that are
		// being updated populated + the primary key.
		// The method should return a full object with the same primary key.
		personsList.add(person);
		System.out.println(person);
		return person;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public @ResponseBody
	Person createPerson() {
		// This should create a new person with a new primary key
		Person p = new Person();
		p.setId((int) (Math.random() * 100000));
		personsList.add(p);
		return p;
	}

	@RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	Person deletePerson(@PathVariable("id") Integer id) {
		// This should delete a person and return the deleted person object
		Person p = new Person();
		p.setId(id);
		if (personsList.remove(p)) {
			return p;
		} else {
			return null;
		}
	}

	public @ResponseBody
	String defaultHandler() {
		// This should delete a person and return the deleted person object
		System.out
				.println("############ *** NO MAPPING FOUND #####################");
		return "############ *** NO MAPPING FOUND #####################";
	}

}
