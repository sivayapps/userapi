/**
 * 
 */
package com.boshanam.user.core.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.boshanam.user.core.model.DomainObjectImpl;
import com.boshanam.user.core.model.IEntity;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Mar 21, 2012 11:46:10 PM
 * 
 */
@Entity
public class PrivilegeAssignment extends DomainObjectImpl<Long> implements IEntity {

	private static final long serialVersionUID = -2381551442281069413L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	public PrivilegeAssignment() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.boshanam.user.core.model.DomainObjectImpl#getId()
	 */
	@Override
	public Long getId() {
		return this.id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.boshanam.user.core.model.DomainObjectImpl#setId(java.io.Serializable)
	 */
	@Override
	public void setId(Long id) {
		this.id = id;
	}

}
