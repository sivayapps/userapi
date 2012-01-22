/**
 * 
 */
package com.boshanam.user.core.persistence.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Dec 17, 2011 11:50:27 AM
 * 
 */
public interface IGenericDao<T, ID extends Serializable> {

	/**
	 * Method to determine if id exist in DB
	 * 
	 * @param id
	 * @return if the Id exists
	 */
	public boolean exists(ID id);

	/**
	 * 
	 * findById
	 * 
	 * @param id
	 * @return T
	 */
	T findById(ID id);

	/**
	 * findById
	 * 
	 * @param id
	 * @param joinSizeFetchMode
	 * @return T
	 */
	T findById(ID id, Integer joinSizeFetchMode);

	/**
	 * findAll
	 * 
	 * @return List<T>
	 * 
	 */
	List<T> findAll();

	/**
	 * findAll
	 * 
	 * @param joinSizeFetchMode
	 * 
	 * @return List<T>
	 */
	List<T> findAll(Integer joinSizeFetchMode);

	/**
	 * persist
	 * 
	 * @param entity
	 */
	void persist(T entity);

	/**
	 * persistEntityId
	 * 
	 * @param entity
	 * @return the Id of the entity persists
	 */
	ID persistEntityId(T entity);

	/**
	 * Persist an entity
	 * 
	 * @param entity
	 * @return T
	 */
	T create(T entity);

	/**
	 * Update an entity
	 * 
	 * @param entity
	 * @return T
	 */
	T update(T entity);

	/**
	 * merge
	 * 
	 * @param entity
	 * @return T
	 */
	T merge(T entity);

	/**
	 * mergeAndPersist
	 * 
	 * @param entity
	 * 
	 */
	void mergeAndPersist(T entity);

	/**
	 * remove
	 * 
	 * @param entity
	 */
	void remove(T entity);

	/**
	 * remove the entity that have the ID
	 * 
	 * @param id
	 * @return The id of the removed id
	 */
	ID removeId(ID id);

	// BELOW THE METHOD FOCUSING ON MASSIVE MANAGEMENT
	// TODO add on demand

}
