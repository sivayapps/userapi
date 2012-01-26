/**
 * 
 */
package com.boshanam.user.core.dto;

import java.util.Date;
import java.util.Map;

import com.boshanam.user.core.model.IPrivilege;
import com.boshanam.user.core.model.IRole;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Dec 15, 2011 10:12:10 PM
 * 
 */
public class RoleDto extends SecureObjectDto implements IRole {

	private static final long serialVersionUID = -319319070140781803L;
	private Map<IPrivilege, Date> privileges;

	public RoleDto() {
	}

	/**
	 * @param id
	 */
	public RoleDto(Long id) {
		super(id);
	}

	public Map<IPrivilege, Date> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Map<IPrivilege, Date> privileges) {
		this.privileges = privileges;
	}

}
