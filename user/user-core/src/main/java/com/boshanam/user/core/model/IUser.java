/**
 * 
 */
package com.boshanam.user.core.model;

import java.util.Date;
import java.util.Map;

import com.boshanam.user.core.dto.PrivilegeDto;
import com.boshanam.user.core.dto.RoleDto;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Jan 24, 2012 12:30:39 AM
 * 
 */
public interface IUser extends ISecureObject {

	public String getEmail();

	public void setEmail(String email);

	public Date getDob();

	public void setDob(Date dob);

	public String getPhone();

	public void setPhone(String phone);

	public String getPwd();

	public void setPwd(String pwd);

	public Map<RoleDto, Date> getRoles();

	public void setRoles(Map<RoleDto, Date> roles);

	public Map<PrivilegeDto, Date> getPrivileges();

	public void setPrivileges(Map<PrivilegeDto, Date> privileges);

}