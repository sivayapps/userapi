/**
 * 
 */
package com.boshanam.user.core.dto;

import java.util.Date;
import java.util.Map;

import com.boshanam.user.core.model.IUser;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Dec 15, 2011 10:57:09 PM
 * 
 */
public class UserDto extends SecureObjectDto implements IUser {

	private static final long serialVersionUID = -336561930588082416L;

	private String email;
	private Date dob;
	private String phone;
	private String pwd;
	private Map<RoleDto, Date> roles;
	private Map<PrivilegeDto, Date> privileges;

	public UserDto() {
	}

	/**
	 * @param id
	 */
	public UserDto(Long id) {
		super(id);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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

}
