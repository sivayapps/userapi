/**
 * 
 */
package com.boshanam.user.core.dto;

import com.boshanam.user.core.model.IPrivilege;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Dec 15, 2011 9:22:06 PM
 * 
 */
public class PrivilegeDto extends SecureObjectDto implements IPrivilege {

	private static final long serialVersionUID = 3757704085850689664L;

	public PrivilegeDto() {
	}

	/**
	 * @param id
	 */
	public PrivilegeDto(Long id) {
		super(id);
	}

}
