/**
 * 
 */
package com.boshanam.user.core.service;

import java.util.List;

import com.boshanam.user.core.dto.PersonDto;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Jan 4, 2012 12:52:47 PM
 * 
 */
public interface IPersonService {

	public List<PersonDto> getAllPersons();

	/**
	 * This should create a new person with a new primary key
	 * 
	 * @return
	 */
	public PersonDto createPerson();

	public PersonDto updatePerson(PersonDto personData);

	/**
	 * This should delete a person and return the deleted person object
	 * 
	 * @param id
	 * @return
	 */
	public PersonDto deletePerson(Long id);

}
