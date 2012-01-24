/**
 * 
 */
package com.boshanam.user.core.persistence.dao.google.impl;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.jpa.JpaCallback;

import com.boshanam.user.core.model.entities.Person;
import com.boshanam.user.core.persistence.dao.IPersonDao;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Jan 8, 2012 2:33:18 AM
 * 
 */
public class PersonDaoGoogleImpl extends GenericDaoGaeImpl<Person, Long> implements IPersonDao<Person> {

	private static Logger sLogger = LoggerFactory.getLogger(PersonDaoGoogleImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.boshanam.user.core.persistence.dao.GenericDao#persistEntityId(java
	 * .lang.Object)
	 */
	public Long persistEntityId(Person entity) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.boshanam.user.core.persistence.dao.GenericDao#create(java.lang.Object )
	 */
	public Person create(Person p) {

		if (p == null) {
			p = new Person();
		}
		sLogger.debug("###########  DAO create() ##################");
		this.getJpaTemplate().persist(p);

		sLogger.debug("###########  DAO create() Person Entity created and persisted : " + p);
		return p;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.boshanam.user.core.persistence.dao.GenericDao#update(java.lang.Object )
	 */
	public Person update(Person p) {

		sLogger.debug("###########  DAO update() ##################");
		this.getJpaTemplate().persist(p);
		return p;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.boshanam.user.core.persistence.dao.GenericDao#merge(java.lang.Object)
	 */
	public Person merge(Person entity) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.boshanam.user.core.persistence.dao.GenericDao#mergeAndPersist(java
	 * .lang.Object)
	 */
	public void mergeAndPersist(Person entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.boshanam.user.core.persistence.dao.GenericDao#remove(java.lang.Object )
	 */
	public void remove(Person entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.boshanam.user.core.persistence.dao.GenericDao#removeId(java.io.
	 * Serializable)
	 */
	public Long removeId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
