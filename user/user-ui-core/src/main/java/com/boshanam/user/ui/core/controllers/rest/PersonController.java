package com.boshanam.user.ui.core.controllers.rest;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boshanam.user.core.dto.PersonDto;
import com.boshanam.user.core.service.IPersonService;

/**
 * @author Swetha
 * 
 */
@Controller
@RequestMapping("/person")
public class PersonController {

	private static Logger sLogger = LoggerFactory.getLogger(PersonController.class);

	@Resource(name="personService")
	private IPersonService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody
	List<PersonDto> getAllPersons() {

		sLogger.debug("#############################  get All persons ************** ##################");
		return service.getAllPersons();
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public @ResponseBody
	PersonDto updatePerson(@ModelAttribute PersonDto personData) {
		// The person object will only have the fields that are
		// being updated populated + the primary key.
		// The method should return a full object with the same primary key.
		sLogger.debug("#############################  Update person ************** ##################");
		return service.updatePerson(personData);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public @ResponseBody
	PersonDto createPerson() {
		// This should create a new person with a new primary key

		sLogger.debug("#############################  Create person ************** ##################");
		return service.createPerson();
	}

	@RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	PersonDto deletePerson(@PathVariable("id") Long id) {
		sLogger.debug("#############################  Delete person ************** ##################");
		// This should delete a person and return the deleted person object
		return service.deletePerson(id);
	}

	public @ResponseBody
	String defaultHandler() {
		// This should delete a person and return the deleted person object
		return "############ *** NO MAPPING FOUND #####################";
	}

	public IPersonService getService() {
		return service;
	}

	public void setService(IPersonService service) {
		this.service = service;
	}

}
