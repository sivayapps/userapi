/**
 * 
 */
package com.boshanam.user.core.model;

import java.util.Date;
import java.util.Map;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Jan 26, 2012 12:48:56 AM
 * 
 */
public interface IRole extends ISecureObject {

	public Map<IPrivilege, Date> getPrivileges();

	public void setPrivileges(Map<IPrivilege, Date> privileges);

}
