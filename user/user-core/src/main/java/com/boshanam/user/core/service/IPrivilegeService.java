/**
 * 
 */
package com.boshanam.user.core.service;

import java.util.List;

import com.boshanam.user.core.dto.PrivilegeDto;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Jan 4, 2012 12:52:47 PM
 * 
 */
public interface IPrivilegeService {

	public List<PrivilegeDto> getAllPrivileges();

	/**
	 * This should create a new person with a new primary key
	 * 
	 * @return
	 */
	public PrivilegeDto createPrivilege();

	public PrivilegeDto updatePrivilege(PrivilegeDto privilegeData);

	/**
	 * This should delete a person and return the deleted person object
	 * 
	 * @param id
	 * @return
	 */
	public PrivilegeDto deletePrivilege(Long id);

}
