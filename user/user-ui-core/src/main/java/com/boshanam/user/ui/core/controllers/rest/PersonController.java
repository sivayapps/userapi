package com.boshanam.user.ui.core.controllers.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boshanam.user.domain.Person;

/**
 * @author Swetha
 * 
 */
@Controller
@RequestMapping("/person")
public class PersonController {

	private static Logger sLogger = LoggerFactory.getLogger(PersonController.class);


	private Map<Integer, Person> persons = Collections
			.synchronizedMap(new HashMap<Integer, Person>());

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody
	List<Person> getAllPersons() {
		if (persons.size() > 0) {
			return new ArrayList<Person>(persons.values());
		}
		// Return a list of Person objects
		Person p = new Person();
		p.setId(persons.size());
		p.setName("OmSriSairam");
		persons.put(p.getId(), p);
		sLogger.debug("#############################  Got it ************** ##################");
		return new ArrayList<Person>(persons.values());
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public @ResponseBody
	Person updatePerson(@ModelAttribute Person personData) {
		// The person object will only have the fields that are
		// being updated populated + the primary key.
		// The method should return a full object with the same primary key.

		sLogger.debug("########## Trying to finfd Updating Person: " + personData);
		Person p = persons.get(personData.getId());
		if (p != null) {
			sLogger.debug("########## Found Person to Update: " + p);
			sLogger.debug("########## Before Update Persons List: "
					+ persons);
			// persons.put(person.getId(),person);
			if (personData.getName() != null) {
				p.setName(personData.getName());
			}
			sLogger.debug("########## Updated Person: " + personData);
			sLogger.debug("########## After Update Persons List: "
					+ persons);
		} else {
			sLogger.debug("########## Person not found to Update");
		}
		return p;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public @ResponseBody
	Person createPerson() {
		// This should create a new person with a new primary key
		Person p = new Person();
		p.setId(persons.size() + 1);
		sLogger.debug("########## Created Person: " + p);
		persons.put(p.getId(), p);
		sLogger.debug(
				"########## After ADD(add new Person), Persons List: "
						+ persons);
		sLogger.debug("########## Returning Person: " + p);
		return p;
	}

	@RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	Person deletePerson(@PathVariable("id") Integer id) {
		// This should delete a person and return the deleted person object
		Person p = new Person();
		p.setId(id);
		return persons.remove(p.getId());
	}

	public @ResponseBody
	String defaultHandler() {
		// This should delete a person and return the deleted person object
		return "############ *** NO MAPPING FOUND #####################";
	}

}
