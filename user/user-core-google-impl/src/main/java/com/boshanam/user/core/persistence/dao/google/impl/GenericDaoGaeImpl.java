/**
 * 
 */
package com.boshanam.user.core.persistence.dao.google.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.support.JpaDaoSupport;

import com.boshanam.user.core.model.IDomainObject;
import com.boshanam.user.core.persistence.dao.IGenericDao;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Jan 24, 2012 7:50:42 PM
 * 
 */
public class GenericDaoGaeImpl<T extends IDomainObject<ID>, ID extends Serializable> extends JpaDaoSupport implements IGenericDao<T, ID> {

	protected static Logger sLogger = LoggerFactory.getLogger(GenericDaoGaeImpl.class);

	protected Class<T> persistentClass;

	/**
	 * This is default constructor used when this generic dao is extended by
	 * specific dao's.
	 */
	@SuppressWarnings("unchecked")
	public GenericDaoGaeImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * This constructor is expected to be used when instantiating this generic dao
	 * instead of specific one. This is generally used in spring bean definitions,
	 * (use as an abstract bean definition and extended in each specific case by
	 * passing constructor-arg's, this will simplify the code by reusing generic
	 * dao implementation instead of creating specific dao's, we can use generic
	 * one in specific cases as well.
	 * 
	 * At the same time this will simplify the spring bean definitions by creating
	 * abstract bean definition with generic dao at once and extending that bean
	 * definition and creating specific bean definitions by passing
	 * constructor-arg as specific entity class name).
	 * 
	 * @param persistentClass
	 */
	public GenericDaoGaeImpl(final Class<T> persistentClass) {
		super();
		this.persistentClass = persistentClass;
		sLogger = LoggerFactory.getLogger(this.getClass().getName() + "<" + this.persistentClass.getSimpleName() + ">");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.boshanam.user.core.persistence.dao.IGenericDao#exists(java.io.Serializable
	 * )
	 */
	@Override
	public boolean exists(ID id) {
		return (id != null) ? (this.getJpaTemplate().find(this.persistentClass, id) != null) : false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.boshanam.user.core.persistence.dao.IGenericDao#findById(java.io.
	 * Serializable)
	 */
	@Override
	public T findById(ID id) {
		return this.getJpaTemplate().find(this.persistentClass, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.boshanam.user.core.persistence.dao.IGenericDao#findById(java.io.
	 * Serializable, java.lang.Integer)
	 */
	@Override
	public T findById(ID id, Integer joinSizeFetchMode) {
		// TODO Auto-generated method stub
		sLogger.warn("findById(ID id, Integer joinSizeFetchMode), This operation is Not yet implemented");
		throw new UnsupportedOperationException("Not yet implemented");
		// return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.boshanam.user.core.persistence.dao.IGenericDao#findAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return this.getJpaTemplate().executeFind(new JpaCallback<List<T>>() {
			public List<T> doInJpa(EntityManager em) throws PersistenceException {
				Query q = em.createQuery("SELECT p FROM " + persistentClass.getName() + " p");
				List<T> result = (List<T>) q.getResultList();
				if (result != null && result.size() > 0) {
					return result;
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
	 * com.boshanam.user.core.persistence.dao.IGenericDao#findAll(java.lang.Integer
	 * )
	 */
	@Override
	public List<T> findAll(Integer joinSizeFetchMode) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.boshanam.user.core.persistence.dao.IGenericDao#persist(java.lang.Object
	 * )
	 */
	@Override
	public void persist(T entity) {
		sLogger.debug("###########  DAO persist() ##################" + entity);
		this.getJpaTemplate().persist(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.boshanam.user.core.persistence.dao.IGenericDao#persistEntityId(java
	 * .lang.Object)
	 */
	@Override
	public ID persistEntityId(T entity) {
		sLogger.debug("###########  DAO persistEntityId() ##################" + entity);
		this.getJpaTemplate().persist(entity);
		this.getJpaTemplate().flush();
		return entity.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.boshanam.user.core.persistence.dao.IGenericDao#create(java.lang.Object)
	 */
	@Override
	public T create(T entity) {
		sLogger.debug("###########  DAO create() ##################");
		this.getJpaTemplate().persist(entity);
		sLogger.debug("###########  DAO create() Person Entity created and persisted : " + entity);
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.boshanam.user.core.persistence.dao.IGenericDao#update(java.lang.Object)
	 */
	@Override
	public T update(T entity) {
		sLogger.debug("###########  DAO update() ##################" + entity);
		entity = this.getJpaTemplate().merge(entity);
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.boshanam.user.core.persistence.dao.IGenericDao#merge(java.lang.Object)
	 */
	@Override
	public T merge(T entity) {
		sLogger.debug("###########  DAO merge() ##################" + entity);
		entity = this.getJpaTemplate().merge(entity);
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.boshanam.user.core.persistence.dao.IGenericDao#mergeAndPersist(java
	 * .lang.Object)
	 */
	@Override
	public void mergeAndPersist(T entity) {
		sLogger.debug("###########  DAO mergeAndPersist() ##################" + entity);
		this.getJpaTemplate().persist(this.getJpaTemplate().merge(entity));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.boshanam.user.core.persistence.dao.IGenericDao#remove(java.lang.Object)
	 */
	@Override
	public void remove(T entity) {
		sLogger.debug("###########  DAO remove() ##################" + entity);
		if (entity != null) {
			this.getJpaTemplate().remove(this.getJpaTemplate().merge(entity));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.boshanam.user.core.persistence.dao.IGenericDao#removeId(java.io.
	 * Serializable)
	 */
	@Override
	public ID removeId(ID id) {
		T _t = null;
		if (id != null) {
			_t = this.findById(id);
			this.remove(_t);
		}
		// remove the id
		return (_t != null) ? id : null;
	}

	/**
	 * @return the persistentClass
	 */
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	/**
	 * @param persistentClass
	 *          the persistentClass to set
	 */
	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

}
