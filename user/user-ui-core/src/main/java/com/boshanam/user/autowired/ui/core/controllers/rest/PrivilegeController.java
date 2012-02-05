package com.boshanam.user.autowired.ui.core.controllers.rest;

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

import com.boshanam.user.core.dto.PrivilegeDto;
import com.boshanam.user.core.service.IPrivilegeService;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Jan 28, 2012 5:48:16 PM
 * 
 */
@Controller
@RequestMapping("/privilege")
public class PrivilegeController {

	private static Logger sLogger = LoggerFactory.getLogger(PrivilegeController.class);

	@Resource(name = "privilegeService")
	private IPrivilegeService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody
	List<PrivilegeDto> getAll() {

		sLogger.debug("#############################  get All Privileges ************** ##################");
		return service.getAllPrivileges();
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public @ResponseBody
	PrivilegeDto update(@ModelAttribute PrivilegeDto privilegeData) {
		// The person object will only have the fields that are
		// being updated populated + the primary key.
		// The method should return a full object with the same primary key.
		sLogger.debug("#############################  Update Privilege ************** ##################");
		return service.updatePrivilege(privilegeData);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public @ResponseBody
	PrivilegeDto create() {
		// This should create a new person with a new primary key

		sLogger.debug("#############################  Create Privilege ************** ##################");
		return service.createPrivilege();
	}

	@RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	PrivilegeDto delete(@PathVariable("id") Long id) {
		sLogger.debug("#############################  Delete Privilege ************** ##################");
		// This should delete a person and return the deleted person object
		return service.deletePrivilege(id);
	}

	public @ResponseBody
	String defaultHandler() {
		// This should delete a person and return the deleted person object
		return "############ *** NO MAPPING FOUND #####################";
	}

	public IPrivilegeService getService() {
		return service;
	}

	public void setService(IPrivilegeService service) {
		this.service = service;
	}

}
