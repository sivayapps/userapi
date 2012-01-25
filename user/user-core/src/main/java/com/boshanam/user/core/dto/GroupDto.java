/**
 * 
 */
package com.boshanam.user.core.dto;

import java.util.Date;
import java.util.Map;

import com.boshanam.user.core.model.IGroup;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Dec 15, 2011 10:50:00 PM
 * 
 */
public class GroupDto extends SecureObjectDto implements IGroup {

	private static final long serialVersionUID = 4459346640272385433L;

	private Map<RoleDto, Date> roles;
	private Map<PrivilegeDto, Date> privileges;
	private Map<UserDto, Date> users;

	public GroupDto() {
	}

	/**
	 * @param id
	 */
	public GroupDto(Long id) {
		super(id);
	}

	public Map<RoleDto, Date> getRoles() {
		return roles;
	}

	public void setRoles(Map<RoleDto, Date> roles) {
		this.roles = roles;
	}

	public Map<PrivilegeDto, Date> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Map<PrivilegeDto, Date> privileges) {
		this.privileges = privileges;
	}

	public Map<UserDto, Date> getUsers() {
		return users;
	}

	public void setUsers(Map<UserDto, Date> users) {
		this.users = users;
	}

}
