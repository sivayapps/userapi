/**
 * 
 */
package com.boshanam.user.core.persistence.dao.classic.impl;

import org.slf4j.LoggerFactory;

import com.boshanam.user.core.model.entities.Person;
import com.boshanam.user.core.persistence.dao.IPersonDao;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Jan 8, 2012 2:33:18 AM
 * 
 */
public class PersonDaoGoogleImpl extends GenericDaoGaeImpl<Person, Long> implements IPersonDao<Person> {

	public PersonDaoGoogleImpl() {
		sLogger = LoggerFactory.getLogger(PersonDaoGoogleImpl.class);
	}

}
