/**
 * 
 */
package com.boshanam.user.core.model;

import java.util.Date;
import java.util.Map;

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

	public Map<IRole, Date> getRoles();

	public void setRoles(Map<IRole, Date> roles);

	public Map<IPrivilege, Date> getPrivileges();

	public void setPrivileges(Map<IPrivilege, Date> privileges);

}
