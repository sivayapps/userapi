/**
 * 
 */
package com.boshanam.user.core.model;

import java.util.Date;
import java.util.Map;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Jan 26, 2012 12:54:46 AM
 * 
 */
public interface IGroup extends ISecureObject {

	public Map<IRole, Date> getRoles();

	public void setRoles(Map<IRole, Date> roles);

	public Map<IPrivilege, Date> getPrivileges();

	public void setPrivileges(Map<IPrivilege, Date> privileges);

	public Map<IUser, Date> getUsers();

	public void setUsers(Map<IUser, Date> users);

}
