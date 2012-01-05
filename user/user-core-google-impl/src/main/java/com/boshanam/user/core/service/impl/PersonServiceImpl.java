/**
 * 
 */
package com.boshanam.user.core.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.boshanam.user.core.dto.PersonDto;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Jan 4, 2012 1:08:05 PM
 * 
 */
public class PersonServiceImpl implements com.boshanam.user.core.service.IPersonService {

	private static Logger sLogger = LoggerFactory.getLogger(PersonServiceImpl.class);

	private Map<Long, PersonDto> persons;

	public PersonServiceImpl() {
		persons = Collections.synchronizedMap(new HashMap<Long, PersonDto>());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.boshanam.user.core.service.IPersonService#getAllPersons()
	 */
	public List<PersonDto> getAllPersons() {
		if (persons.size() > 0) {
			return new ArrayList<PersonDto>(persons.values());
		}
		// Return a list of PersonDto objects
		PersonDto p = new PersonDto();
		p.setId((long) persons.size());
		p.setName("OmSriSairam");
		persons.put(p.getId(), p);
		sLogger.debug("#############################  Got it ************** ##################");
		return new ArrayList<PersonDto>(persons.values());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.boshanam.user.core.service.IPersonService#createPerson()
	 */
	public PersonDto createPerson() {
		// This should create a new person with a new primary key
		PersonDto p = new PersonDto();
		p.setId((long) (persons.size() + 1));
		sLogger.debug("########## Created PersonDto: " + p);
		persons.put(p.getId(), p);
		sLogger.debug("########## After ADD(add new PersonDto), Persons List: " + persons);
		sLogger.debug("########## Returning PersonDto: " + p);
		return p;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.boshanam.user.core.service.IPersonService#updatePerson(com.boshanam
	 * .user.core.dto.PersonDto)
	 */
	public PersonDto updatePerson(PersonDto personData) {
		// The person object will only have the fields that are
		// being updated populated + the primary key.
		// The method should return a full object with the same primary key.
		sLogger.debug("########## Trying to find Updating Persons: " + personData);
		PersonDto p = persons.get(personData.getId());
		if (p != null) {
			sLogger.debug("########## Found PersonDto to Update: " + p);
			sLogger.debug("########## Before Update Persons List: " + persons);
			// persons.put(person.getId(),person);
			if (personData.getName() != null) {
				p.setName(personData.getName());
			}
			sLogger.debug("########## Updated PersonDto: " + personData);
			sLogger.debug("########## After Update Persons List: " + persons);
		} else {
			sLogger.debug("########## PersonDto not found to Update");
		}
		return p;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.boshanam.user.core.service.IPersonService#deletePerson(java.lang.
	 * Long)
	 */
	public PersonDto deletePerson(Long id) {
		PersonDto p = new PersonDto();
		p.setId(id);
		return persons.remove(p.getId());
	}

}
