/**
 * 
 */
package com.boshanam.user.core.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.boshanam.user.core.dto.PersonDto;
import com.boshanam.user.core.persistence.dao.PersonDao;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Jan 4, 2012 1:08:05 PM
 * 
 */
public class PersonServiceImpl implements com.boshanam.user.core.service.IPersonService {

	private static Logger sLogger = LoggerFactory.getLogger(PersonServiceImpl.class);

	private PersonDao personDao;

	public PersonServiceImpl() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.boshanam.user.core.service.IPersonService#getAllPersons()
	 */
	public List<PersonDto> getAllPersons() {
		return personDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.boshanam.user.core.service.IPersonService#createPerson()
	 */
	public PersonDto createPerson() {
		// This should create a new person with a new primary key
		PersonDto p = new PersonDto();
		personDao.create(p);
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
		PersonDto p = personDao.findById(personData.getId());
		if (p != null) {
			sLogger.debug("########## Found PersonDto to Update: " + p);
			// persons.put(person.getId(),person);
			p.setName(personData.getName());
			personDao.update(p);
			sLogger.debug("########## Updated PersonDto: " + personData);
		} else {
			sLogger.debug("########## PersonDto not found to Update, creating now");
			personDao.persist(personData);
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
		PersonDto dto = personDao.findById(id);
		if (dto != null) {
			personDao.removeId(id);
		}
		return dto;
	}

	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

}
