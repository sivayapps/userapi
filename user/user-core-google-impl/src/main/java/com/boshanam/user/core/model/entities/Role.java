/**
 * 
 */
package com.boshanam.user.core.model.entities;

import java.util.Date;
import java.util.Map;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.Transient;

import com.boshanam.user.core.model.IPrivilege;
import com.boshanam.user.core.model.IRole;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Jan 26, 2012 4:07:10 PM
 * 
 */
public class Role extends SecureObject implements IRole {

	private static final long serialVersionUID = 856666457310633306L;

	@Basic(fetch = FetchType.EAGER)
	private Map<Long, Date> privilegeIds;

	@Transient
	private Map<IPrivilege, Date> privileges;

	public Map<IPrivilege, Date> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Map<IPrivilege, Date> privileges) {
		this.privileges = privileges;
	}

	/**
	 * @return the privilegeIds
	 */
	public Map<Long, Date> getPrivilegeIds() {
		return privilegeIds;
	}

	/**
	 * @param privilegeIds the privilegeIds to set
	 */
	public void setPrivilegeIds(Map<Long, Date> privilegeIds) {
		this.privilegeIds = privilegeIds;
	}

}
