package com.boshanam.user.core.dto;

import java.io.Serializable;

/**
 * A common base class for all DTO's. As all the Entities expected to have id.
 * It is abstracted to this base class, instead of adding in every class.
 * 
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Dec 15, 2011 9:15:53 PM
 * 
 */
public class ObjectDto implements Serializable {

	private static final long serialVersionUID = -1239682838384783476L;
	protected Long id;

	public ObjectDto() {
	}

	public ObjectDto(Long id) {
		setId(id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		// here if id is null, then we are falling back to native hash code of
		// Object as we don't want two DTO/Entities without id assigned to be
		// treated as
		// equal. If we return different hash code for different entities
		result = prime * result + ((getId() == null) ? super.hashCode() : getId().hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ObjectDto other = (ObjectDto) obj;
		if (getId() == null) {
			// here we have to treat objects as unequal if any of the ID is NULL or
			// even both Entitie's ID's are NULL, this allows us to store more than
			// one Transient (Entity objects not yet persisted) into Set or Hash based
			// collections.
			return false;
		} else if (!getId().equals(other.getId())) {
			return false;
		}
		return true;
	}
}
