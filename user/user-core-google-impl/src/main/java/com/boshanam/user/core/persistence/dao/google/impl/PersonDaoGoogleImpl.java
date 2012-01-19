/**
 * 
 */
package com.boshanam.user.core.persistence.dao.google.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.support.JpaDaoSupport;

import com.boshanam.user.core.dto.PersonDto;
import com.boshanam.user.core.model.entities.Person;
import com.boshanam.user.core.persistence.dao.PersonDao;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Jan 8, 2012 2:33:18 AM
 * 
 */
public class PersonDaoGoogleImpl extends JpaDaoSupport implements PersonDao {

	private static Logger sLogger = LoggerFactory.getLogger(PersonDaoGoogleImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.boshanam.user.core.persistence.dao.GenericDao#exists(java.io.Serializable
	 * )
	 */
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.boshanam.user.core.persistence.dao.GenericDao#findById(java.io.
	 * Serializable)
	 */
	public PersonDto findById(Long id) {

		Person p = this.getJpaTemplate().find(Person.class, id);
		if (p != null) {
			PersonDto dto = new PersonDto();
			dto.setId(p.getId());
			dto.setName(p.getName());
			return dto;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.boshanam.user.core.persistence.dao.GenericDao#findById(java.io.
	 * Serializable, java.lang.Integer)
	 */
	public PersonDto findById(Long id, Integer joinSizeFetchMode) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.boshanam.user.core.persistence.dao.GenericDao#findAll()
	 */
	@SuppressWarnings("unchecked")
	public List<PersonDto> findAll() {
		return this.getJpaTemplate().executeFind(new JpaCallback<List<PersonDto>>() {
			public List<PersonDto> doInJpa(EntityManager em) throws PersistenceException {
				Query q = em.createQuery("SELECT p FROM com.boshanam.user.core.model.entities.Person p");
				List<Person> result = (List<Person>) q.getResultList();
				List<PersonDto> voList = new ArrayList<PersonDto>();
				if (result != null && result.size() > 0) {
					for (Person u : result) {
						PersonDto dto = new PersonDto();
						dto.setId(u.getId());
						dto.setName(u.getName());
						voList.add(dto);
					}
					return voList;
				} else {
					return Collections.emptyList();
				}
			}

		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.boshanam.user.core.persistence.dao.GenericDao#findAll(java.lang.Integer
	 * )
	 */
	public List<PersonDto> findAll(Integer joinSizeFetchMode) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.boshanam.user.core.persistence.dao.GenericDao#persist(java.lang.Object
	 * )
	 */
	public void persist(PersonDto entity) {
		throw new UnsupportedOperationException("Not yet implemented siva TODO");
//		this.getJpaTemplate().persist(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.boshanam.user.core.persistence.dao.GenericDao#persistEntityId(java
	 * .lang.Object)
	 */
	public Long persistEntityId(PersonDto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.boshanam.user.core.persistence.dao.GenericDao#create(java.lang.Object
	 * )
	 */
	public PersonDto create(PersonDto dto) {

		Person p = new Person();
		sLogger.debug("###########  DAO create() ##################");
		this.getJpaTemplate().persist(p);
		dto.setId(p.getId());
		dto.setName(p.getName());

		sLogger.debug("###########  DAO create() Person Entity created and persisted : " + dto);
		return dto;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.boshanam.user.core.persistence.dao.GenericDao#update(java.lang.Object
	 * )
	 */
	public PersonDto update(PersonDto pDto) {
		Person p = new Person();
		p.setId(pDto.getId());
		p.setName(pDto.getName());
		sLogger.debug("###########  DAO update() ##################");
		this.getJpaTemplate().persist(p);
		return pDto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.boshanam.user.core.persistence.dao.GenericDao#merge(java.lang.Object)
	 */
	public PersonDto merge(PersonDto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.boshanam.user.core.persistence.dao.GenericDao#mergeAndPersist(java
	 * .lang.Object)
	 */
	public void mergeAndPersist(PersonDto entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.boshanam.user.core.persistence.dao.GenericDao#remove(java.lang.Object
	 * )
	 */
	public void remove(PersonDto entity) {
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
