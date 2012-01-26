/**
 * 
 */
package com.boshanam.user.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.boshanam.user.core.dto.PrivilegeDto;
import com.boshanam.user.core.model.entities.Privilege;
import com.boshanam.user.core.persistence.dao.IPrivilegeDao;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Jan 4, 2012 1:08:05 PM
 * 
 */
public class PrivilegeServiceImpl implements com.boshanam.user.core.service.IPrivilegeService {

	private static Logger sLogger = LoggerFactory.getLogger(PrivilegeServiceImpl.class);

	private IPrivilegeDao<Privilege> privilegeDao;

	public PrivilegeServiceImpl() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.boshanam.user.core.service.IPersonService#getAllPersons()
	 */
	public List<PrivilegeDto> getAllPrivileges() {
		List<Privilege> persons = privilegeDao.findAll();
		List<PrivilegeDto> personDtoList = new ArrayList<PrivilegeDto>();
		if (persons != null && persons.size() > 0) {
			for (Privilege u : persons) {
				PrivilegeDto dto = new PrivilegeDto();
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
	public PrivilegeDto createPrivilege() {
		// This should create a new person with a new primary key
		Privilege p = new Privilege();
		privilegeDao.create(p);
		PrivilegeDto dto = new PrivilegeDto();
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
	public PrivilegeDto updatePrivilege(PrivilegeDto personData) {
		// The person object will only have the fields that are
		// being updated populated + the primary key.
		// The method should return a full object with the same primary key.
		sLogger.debug("########## Trying to find Updating Persons: " + personData);
		Privilege p = privilegeDao.findById(personData.getId());
		if (p != null) {
			sLogger.debug("########## Found PersonDto to Update: " + p);
			// persons.put(person.getId(),person);
			p.setName(personData.getName());
			privilegeDao.update(p);
			sLogger.debug("########## Updated PersonDto: " + personData);
		} else {
			sLogger.debug("########## PersonDto not found to Update, creating now");
			p = dtoToPerson(personData);
			privilegeDao.persist(p);
		}
		return personData;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.boshanam.user.core.service.IPersonService#deletePerson(java.lang.
	 * Long)
	 */
	public PrivilegeDto deletePrivilege(Long id) {
		PrivilegeDto dto = privilegeToDto(privilegeDao.findById(id));
		if (dto != null) {
			privilegeDao.removeId(id);
		}
		return dto;
	}

	public IPrivilegeDao<Privilege> getPrivilegeDao() {
		return privilegeDao;
	}

	public void setPrivilegeDao(IPrivilegeDao<Privilege> personDao) {
		this.privilegeDao = personDao;
	}

	public Privilege dtoToPerson(PrivilegeDto dto) {
		Privilege p = new Privilege();
		p.setId(dto.getId());
		p.setName(dto.getName());
		// TODO need to copy more props
		return p;
	}

	public PrivilegeDto privilegeToDto(Privilege p) {
		PrivilegeDto dto = new PrivilegeDto();
		dto.setId(p.getId());
		dto.setName(p.getName());
		// TODO need to copy more props
		return dto;
	}

}
