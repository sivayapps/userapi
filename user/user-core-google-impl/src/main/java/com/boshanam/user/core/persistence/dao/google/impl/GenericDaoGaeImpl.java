/**
 * 
 */
package com.boshanam.user.core.persistence.dao.google.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.boshanam.user.core.model.IDomainObject;
import com.boshanam.user.core.persistence.dao.IGenericDao;

/**
 * 
 * Generic Implementation of DAO with basic CRUD operations, And is expected to
 * be Extended by Specific DAO's to persist Specific Entity types. <br>
 * 
 * This class has references to EntityManagerFactory and EntityManager.
 * 
 * EntityManagerFactory only be used only when fine grained control is needed
 * and if we are not using Spring( 3.1.0 or higher Spring version recommended).
 * 
 * If Used without Spring and with EntityManagerFactory then, caller should
 * create the EntityManager through "createEntityManager()" and set the EM to
 * this DAO Explicitly before calling the Persistent methods. <br>
 * 
 * 
 * As we are using Spring, it can automatically injects the EntityManager using @PersistenceContext
 * annotation. And the Injected EntityManager is proxy created by spring which
 * is Thread safe and uses current transactional EntityManager internally or
 * creates a new one if current transactional EM is not available.
 * 
 * <br>
 * According to <strong>Spring Reference</strong>: 3.1.0.RELEASE version,
 * Chapter: 14.5 (ORM-->JPA), Page: 418, <br>
 * Snippet of Spring Reference Doc: <br>
 * 
 * Note: <br>
 * Although EntityManagerFactory instances are thread-safe, EntityManager
 * instances are not. The injected JPA EntityManager behaves like an
 * EntityManager fetched from an application server's JNDI environment, as
 * defined by the JPA specification. It delegates all calls to the current
 * transactional EntityManager, if any; otherwise, it falls back to a newly
 * created EntityManager per operation, in effect making its usage thread-safe.
 * 
 * <br>
 * <br>
 * The injected EntityManager is Spring-managed (aware of the ongoing
 * transaction). It is important to note that even though the new DAO
 * implementation uses method level injection of an EntityManager instead of an
 * EntityManagerFactory, no change is required in the application context XML
 * due to annotation usage. The main advantage of this DAO style is that it only
 * depends on Java Persistence API; no import of any Spring class is required.
 * Moreover, as the JPA annotations are understood, the injections are applied
 * automatically by the Spring container.
 * 
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Jan 24, 2012 7:50:42 PM
 * 
 */
public class GenericDaoGaeImpl<T extends IDomainObject<ID>, ID extends Serializable> implements IGenericDao<T, ID> {

	protected static Logger sLogger = LoggerFactory.getLogger(GenericDaoGaeImpl.class);

	@PersistenceContext
	protected EntityManager entityManager;

	@PersistenceUnit
	protected EntityManagerFactory entityManagerFactory;

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
		return (id != null) ? (this.getEntityManager().find(this.persistentClass, id) != null) : false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.boshanam.user.core.persistence.dao.IGenericDao#findById(java.io.
	 * Serializable)
	 */
	@Override
	public T findById(ID id) {
		return this.getEntityManager().find(this.persistentClass, id);
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findById(List<ID> ids) {
		
		Query q = this.getEntityManager().createQuery("select from " + this.persistentClass.getName() + " where id = :ids");
    q.setParameter("ids", ids);
    return q.getResultList();
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
		sLogger.debug("*** findAll() - Querying all entities of kind '{}' ***", persistentClass);
		return this.getEntityManager().createQuery("SELECT p FROM " + persistentClass.getName() + " p").getResultList();
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
		sLogger.debug("###########  DAO persist() ################## {}", entity);
		this.getEntityManager().persist(entity);
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
		sLogger.debug("###########  DAO persistEntityId() ################## {}", entity);
		this.getEntityManager().persist(entity);
		this.getEntityManager().flush();
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
		this.getEntityManager().persist(entity);
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
		sLogger.debug("###########  DAO update() ################## {}", entity);
		entity = this.getEntityManager().merge(entity);
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
		sLogger.debug("###########  DAO merge() ################## {}", entity);
		entity = this.getEntityManager().merge(entity);
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
		sLogger.debug("###########  DAO mergeAndPersist() ################## {}", entity);
		this.getEntityManager().persist(this.getEntityManager().merge(entity));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.boshanam.user.core.persistence.dao.IGenericDao#remove(java.lang.Object)
	 */
	@Override
	public void remove(T entity) {
		sLogger.debug("###########  DAO remove() ################## {}", entity);
		if (entity != null) {
			this.getEntityManager().remove(this.getEntityManager().merge(entity));
		}
	}

	/**
	 * 
	 * Must be done in a Transaction if used with Spring Injected EntityManager
	 * (read class level documentation)., if used with Spring injected
	 * transactional aware proxied EM without any Transactional context, causes
	 * multiple EM's to get created for each persistent method call. And the EM
	 * gets created will be immediately closed after each persistent method call
	 * completion, Effectively making the Entity as DETACHED. But to call
	 * EM.remove(Entity), the Entity passes should be Persistent entity, as after
	 * calling findById(id), the Entity will immediately become DETACHED or at
	 * least not persistent Entity for the newly created EM in EM.remove() method. <br>
	 * To avoid this issue, By calling this remove(ID) in a transactional context,
	 * Spring proxied EM will use the same EM which is used for calling
	 * findById(ID), so the Entity returned by the findByID(ID) call will be
	 * treated as persistent Entity in EM.remove(Entity) call and make the
	 * operation successful.
	 * 
	 * <br>
	 * Another Option is to use the "type" parameter to @PersistenceContext as
	 * "PersistenceContextType.EXTENDED", which mandates the use of single EM, but
	 * its not recommended as the injected EM will not be Thread safe and will not
	 * create EM's on demand. This will just make the remove(ID) operation
	 * successful but it causes more problems without any benefits.
	 * 
	 * <br>
	 * Another approach is to set the EM before calling this method if used with
	 * EMF.
	 **/
	@Override
	public ID removeId(ID id) {
		EntityManager em = createEntityManager();
		EntityTransaction tx = em.getTransaction();
		sLogger.debug("Begining Transaction: {}", tx);
		tx.begin();

		T _t = null;
		if (id != null) {
			_t = em.find(this.persistentClass, id);
			if (_t != null) {
				em.remove(em.merge(_t));
			}
			// this.remove(_t);
		}
		sLogger.debug("Committing Transaction...");
		tx.commit();
		sLogger.debug("Committed Transaction...");
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

	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * @param entityManager
	 *          the entityManager to set
	 */
	public void setEntityManager(EntityManager entityManager) {
		sLogger.debug("*** setting EntityManager: {}", entityManager);
		this.entityManager = entityManager;
	}

	public EntityManager createEntityManager() {
		sLogger.debug("*** Creating EntityManager from Factory: {}.", this.getEntityManagerFactory());
		EntityManager _em = this.getEntityManagerFactory().createEntityManager();
		sLogger.debug("*** Created EntityManager: {} from Factory: {}.", _em, this.getEntityManagerFactory());
		return _em;
	}

	/**
	 * @return the entityManagerFactory
	 */
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	/**
	 * @param entityManagerFactory
	 *          the entityManagerFactory to set
	 */
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		sLogger.debug("*** setting EntityManagerFactory: {}", entityManagerFactory);
		this.entityManagerFactory = entityManagerFactory;
	}

}
