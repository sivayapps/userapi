/**
 * 
 */
package com.boshanam.user.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.boshanam.user.core.dto.PersonDto;
import com.boshanam.user.core.model.entities.Person;
import com.boshanam.user.core.persistence.dao.IPersonDao;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Jan 4, 2012 1:08:05 PM
 * 
 */
public class PersonServiceImpl implements com.boshanam.user.core.service.IPersonService {

	private static Logger sLogger = LoggerFactory.getLogger(PersonServiceImpl.class);

	private IPersonDao<Person> personDao;
	private DozerBeanMapper dozerMapper;

	public PersonServiceImpl() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.boshanam.user.core.service.IPersonService#getAllPersons()
	 */
	public List<PersonDto> getAllPersons() {
		List<Person> persons = personDao.findAll();
		List<PersonDto> personDtoList = new ArrayList<PersonDto>();
		if (persons != null && persons.size() > 0) {
			for (Person u : persons) {
				PersonDto dto = new PersonDto();
				dto.setId(u.getId());
				dto.setName(u.getName());
				personDtoList.add(dto);
			}
		}
		return personDtoList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.boshanam.user.core.service.IPersonService#createPerson()
	 */
	public PersonDto createPerson() {
		// This should create a new person with a new primary key
		Person p = new Person();
		personDao.create(p);
		PersonDto dto = new PersonDto();
		dto.setId(p.getId());
		dto.setName(p.getName());
		return dto;
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
		Person p = personDao.findById(personData.getId());
		if (p != null) {
			sLogger.debug("########## Found PersonDto to Update: " + p);
			// persons.put(person.getId(),person);
			p.setName(personData.getName());
			personDao.update(p);
			sLogger.debug("########## Updated PersonDto: " + personData);
		} else {
			sLogger.debug("########## PersonDto not found to Update, creating now");
			p = dtoToPerson(personData);
			personDao.persist(p);
		}
		return personData;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.boshanam.user.core.service.IPersonService#deletePerson(java.lang.
	 * Long)
	 */
	public PersonDto deletePerson(Long id) {
		PersonDto dto = personToDto(personDao.findById(id));
		if (dto != null) {
			personDao.removeId(id);
		}
		return dto;
	}

	public IPersonDao<Person> getPersonDao() {
		return personDao;
	}

	public void setPersonDao(IPersonDao<Person> personDao) {
		this.personDao = personDao;
	}

	public Person dtoToPerson(PersonDto dto) {
		Person p = new Person();
		p.setId(dto.getId());
		p.setName(dto.getName());
		return p;
	}

	public PersonDto personToDto(Person p) {
		PersonDto dto = new PersonDto();
		dto.setId(p.getId());
		dto.setName(p.getName());
		return dto;
	}

	/**
	 * @return the dozerMapper
	 */
	public DozerBeanMapper getDozerMapper() {
		return dozerMapper;
	}

	/**
	 * @param dozerMapper the dozerMapper to set
	 */
	public void setDozerMapper(DozerBeanMapper dozerMapper) {
		this.dozerMapper = dozerMapper;
	}

}
