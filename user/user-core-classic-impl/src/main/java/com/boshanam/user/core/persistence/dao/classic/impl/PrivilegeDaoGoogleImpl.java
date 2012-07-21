/**
 * 
 */
package com.boshanam.user.core.persistence.dao.classic.impl;

import org.slf4j.LoggerFactory;

import com.boshanam.user.core.model.entities.Privilege;
import com.boshanam.user.core.persistence.dao.IPrivilegeDao;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Jan 8, 2012 2:33:18 AM
 * 
 */
public class PrivilegeDaoGoogleImpl extends GenericDaoGaeImpl<Privilege, Long> implements IPrivilegeDao<Privilege> {

	public PrivilegeDaoGoogleImpl() {
		sLogger = LoggerFactory.getLogger(PrivilegeDaoGoogleImpl.class);
	}

}
