/**
 * 
 */
package com.boshanam.user.core.model.entities;

import javax.persistence.Entity;

import com.boshanam.user.core.model.IPrivilege;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Jan 26, 2012 3:35:23 PM 
 *
 */
@Entity
public class Privilege extends SecureObject implements IPrivilege {

	private static final long serialVersionUID = 8177611621841546069L;

}
