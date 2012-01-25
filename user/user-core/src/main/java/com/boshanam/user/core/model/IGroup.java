/**
 * 
 */
package com.boshanam.user.core.model;

import java.util.Date;
import java.util.Map;

import com.boshanam.user.core.dto.PrivilegeDto;
import com.boshanam.user.core.dto.RoleDto;
import com.boshanam.user.core.dto.UserDto;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Jan 26, 2012 12:54:46 AM
 * 
 */
public interface IGroup extends ISecureObject {

	public Map<RoleDto, Date> getRoles();

	public void setRoles(Map<RoleDto, Date> roles);

	public Map<PrivilegeDto, Date> getPrivileges();

	public void setPrivileges(Map<PrivilegeDto, Date> privileges);

	public Map<UserDto, Date> getUsers();

	public void setUsers(Map<UserDto, Date> users);

}
