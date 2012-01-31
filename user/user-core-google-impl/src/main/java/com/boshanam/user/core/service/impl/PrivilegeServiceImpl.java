/**
 * 
 */
package com.boshanam.user.core.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.boshanam.user.core.dto.Impact;
import com.boshanam.user.core.dto.PrivilegeDto;
import com.boshanam.user.core.mapping.util.DozerMappingUtil;
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
	private DozerMappingUtil dozerMappingUtil;

	public PrivilegeServiceImpl() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.boshanam.user.core.service.IPersonService#getAllPersons()
	 */
	public List<PrivilegeDto> getAllPrivileges() {
		List<Privilege> persons = privilegeDao.findAll();
		if (persons == null || persons.size() == 0) {
			return Collections.emptyList();
		}
		List<PrivilegeDto> personDtoList = new ArrayList<PrivilegeDto>(persons.size());
		getDozerMappingUtil().map(persons, personDtoList);

		// List<PrivilegeDto> personDtoList = new ArrayList<PrivilegeDto>();
		// if (persons != null && persons.size() > 0) {
		// for (Privilege u : persons) {
		// PrivilegeDto dto = new PrivilegeDto();
		// dto.setId(u.getId());
		// dto.setName(u.getName());
		// personDtoList.add(dto);
		// }
		// }
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
		p.setImpact(Impact.Medium);
		privilegeDao.create(p);

		return getDozerMappingUtil().map(p, PrivilegeDto.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.boshanam.user.core.service.IPersonService#updatePerson(com.boshanam
	 * .user.core.dto.PersonDto)
	 */
	public PrivilegeDto updatePrivilege(PrivilegeDto privilegeData) {
		// The person object will only have the fields that are
		// being updated populated + the primary key.
		// The method should return a full object with the same primary key.
		sLogger.debug("########## Trying to find Updating privilege: " + privilegeData);
		Privilege p = privilegeDao.findById(privilegeData.getId());
		if (p != null) {
			sLogger.debug("########## Found privilege to Update: " + p);
			// persons.put(person.getId(),person);
			getDozerMappingUtil().map(privilegeData, p);
			// p.setName(privilegeData.getName());
			privilegeDao.update(p);
			sLogger.debug("########## Updated PersonDto: " + privilegeData);
		} else {
			sLogger.debug("########## PersonDto not found to Update, creating now");
			// p = dtoToPrivilege(privilegeData);
			p = getDozerMappingUtil().map(privilegeData, Privilege.class);
			privilegeDao.persist(p);
		}
		// This copy needed because dto from request may not contain all fields
		// values, so we should copy all fields to dto from persistent entity before
		// returning to view

		getDozerMappingUtil().map(p, privilegeData);
		return privilegeData;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.boshanam.user.core.service.IPersonService#deletePerson(java.lang.
	 * Long)
	 */
	public PrivilegeDto deletePrivilege(Long id) {
		// PrivilegeDto dto = privilegeToDto(privilegeDao.findById(id));
		PrivilegeDto dto = getDozerMappingUtil().map(privilegeDao.findById(id), PrivilegeDto.class);
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

	public Privilege dtoToPrivilege(PrivilegeDto dto) {
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

	/**
	 * @return the dozerMappingUtil
	 */
	public DozerMappingUtil getDozerMappingUtil() {
		return dozerMappingUtil;
	}

	/**
	 * @param dozerMappingUtil
	 *          the dozerMappingUtil to set
	 */
	public void setDozerMappingUtil(DozerMappingUtil dozerMappingUtil) {
		this.dozerMappingUtil = dozerMappingUtil;
	}

}
