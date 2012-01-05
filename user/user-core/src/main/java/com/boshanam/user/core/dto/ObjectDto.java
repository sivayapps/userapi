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
}
