/**
 * 
 */
package com.boshanam.user.core.dto;

import java.util.Date;
import java.util.Map;

import com.boshanam.user.core.model.IGroup;
import com.boshanam.user.core.model.IPrivilege;
import com.boshanam.user.core.model.IRole;
import com.boshanam.user.core.model.IUser;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Dec 15, 2011 10:50:00 PM
 * 
 */
public class GroupDto extends SecureObjectDto implements IGroup {

	private static final long serialVersionUID = 4459346640272385433L;

	private Map<IRole, Date> roles;
	private Map<IPrivilege, Date> privileges;
	private Map<IUser, Date> users;

	public GroupDto() {
	}

	/**
	 * @param id
	 */
	public GroupDto(Long id) {
		super(id);
	}

	/**
	 * @return the roles
	 */
	public Map<IRole, Date> getRoles() {
		return roles;
	}

	/**
	 * @param roles
	 *          the roles to set
	 */
	public void setRoles(Map<IRole, Date> roles) {
		this.roles = roles;
	}

	/**
	 * @return the privileges
	 */
	public Map<IPrivilege, Date> getPrivileges() {
		return privileges;
	}

	/**
	 * @param privileges
	 *          the privileges to set
	 */
	public void setPrivileges(Map<IPrivilege, Date> privileges) {
		this.privileges = privileges;
	}

	/**
	 * @return the users
	 */
	public Map<IUser, Date> getUsers() {
		return users;
	}

	/**
	 * @param users
	 *          the users to set
	 */
	public void setUsers(Map<IUser, Date> users) {
		this.users = users;
	}

}
