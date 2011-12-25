/**
 * 
 */
package com.boshanam.user.core.dto;

import java.util.Date;
import java.util.Map;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Dec 15, 2011 10:12:10 PM
 * 
 */
public class RoleDto extends SecureObjectDto {

	private static final long serialVersionUID = -319319070140781803L;
	private Map<PrivilegeDto, Date> privileges;

	public RoleDto() {
	}

	/**
	 * @param id
	 */
	public RoleDto(Long id) {
		super(id);
	}

	public Map<PrivilegeDto, Date> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Map<PrivilegeDto, Date> privileges) {
		this.privileges = privileges;
	}

}
