/**
 * 
 */
package com.boshanam.user.core.dto;

import java.util.Date;

/**
 * 
 * Base class to be used for Security related objects with some common fields.
 * 
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Dec 15, 2011 9:42:45 PM
 * 
 */
public class SecureObjectDto extends ObjectDto {

	private static final long serialVersionUID = 5706176722836846192L;

	protected String name;
	protected String description;
	protected Boolean active;
	protected Impact impact;
	protected Date creationDate;
	protected Date expiryDate;
	protected Date lastModifiedDate;

	public SecureObjectDto() {
	}

	/**
	 * @param id
	 */
	public SecureObjectDto(Long id) {
		super(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Impact getImpact() {
		return impact;
	}

	public void setImpact(Impact impact) {
		this.impact = impact;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

}
