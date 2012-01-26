/**
 * 
 */
package com.boshanam.user.core.model.entities;

import java.util.Date;
import java.util.Map;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.Transient;

import com.boshanam.user.core.model.IGroup;
import com.boshanam.user.core.model.IPrivilege;
import com.boshanam.user.core.model.IRole;
import com.boshanam.user.core.model.IUser;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Jan 26, 2012 7:15:19 PM
 * 
 */
public class Group extends SecureObject implements IGroup {

	private static final long serialVersionUID = 4552755155862183075L;

	@Basic(fetch = FetchType.EAGER)
	private Map<Long, Date> roleIds;

	@Basic(fetch = FetchType.EAGER)
	private Map<Long, Date> privilegeIds;

	@Basic(fetch = FetchType.EAGER)
	private Map<Long, Date> userIds;

	@Transient
	private Map<IRole, Date> roles;

	@Transient
	private Map<IPrivilege, Date> privileges;

	@Transient
	private Map<IUser, Date> users;

	public Map<IRole, Date> getRoles() {
		return roles;
	}

	public void setRoles(Map<IRole, Date> roles) {
		this.roles = roles;
	}

	public Map<IPrivilege, Date> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Map<IPrivilege, Date> privileges) {
		this.privileges = privileges;
	}

	public Map<IUser, Date> getUsers() {
		return users;
	}

	public void setUsers(Map<IUser, Date> users) {
		this.users = users;
	}

	/**
	 * @return the roleIds
	 */
	public Map<Long, Date> getRoleIds() {
		return roleIds;
	}

	/**
	 * @param roleIds
	 *          the roleIds to set
	 */
	public void setRoleIds(Map<Long, Date> roleIds) {
		this.roleIds = roleIds;
	}

	/**
	 * @return the privilegeIds
	 */
	public Map<Long, Date> getPrivilegeIds() {
		return privilegeIds;
	}

	/**
	 * @param privilegeIds
	 *          the privilegeIds to set
	 */
	public void setPrivilegeIds(Map<Long, Date> privilegeIds) {
		this.privilegeIds = privilegeIds;
	}

	/**
	 * @return the userIds
	 */
	public Map<Long, Date> getUserIds() {
		return userIds;
	}

	/**
	 * @param userIds
	 *          the userIds to set
	 */
	public void setUserIds(Map<Long, Date> userIds) {
		this.userIds = userIds;
	}

}
