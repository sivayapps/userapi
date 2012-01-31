/**
 * 
 */
package com.boshanam.user.core.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.boshanam.user.core.GlobalConstants;
import com.boshanam.user.core.model.ISecureObject;

/**
 * 
 * Base class to be used for Security related objects with some common fields.
 * 
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Dec 15, 2011 9:42:45 PM
 * 
 */
public class SecureObjectDto extends ObjectDto implements ISecureObject {

	private static final long serialVersionUID = 5706176722836846192L;

	protected String name;
	protected String description;
	protected Boolean active;
	protected Impact impact;

	@DateTimeFormat(iso = DateTimeFormat.ISO.NONE, pattern = GlobalConstants.APPLICATION_DATE_TIME_FORMAT)
	protected Date creationDate;

	@DateTimeFormat(iso = DateTimeFormat.ISO.NONE, pattern = GlobalConstants.APPLICATION_DATE_TIME_FORMAT)
	protected Date expiryDate;

	@DateTimeFormat(iso = DateTimeFormat.ISO.NONE, pattern = GlobalConstants.APPLICATION_DATE_TIME_FORMAT)
	protected Date lastModifiedDate;

	public SecureObjectDto() {
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID=").append(getId()).append(", Name=").append(getName()).append(",Description=").append(getDescription()).append(",Active=")
				.append(getActive()).append(",Impact=").append(getImpact()).append(",CreationDate=").append(getCreationDate()).append(",expiryDate=")
				.append(getExpiryDate()).append(",lastModifiedDate=" + getLastModifiedDate());
		return sb.toString();
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
