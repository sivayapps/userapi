/**
 * 
 */
package com.boshanam.user.core.model.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.boshanam.user.core.dto.Impact;
import com.boshanam.user.core.model.DomainObjectImpl;
import com.boshanam.user.core.model.ISecureObject;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Jan 26, 2012 3:17:30 PM
 * 
 */
@Entity
@MappedSuperclass
public class SecureObject extends DomainObjectImpl<Long> implements ISecureObject {

	private static final long serialVersionUID = -9220462938439127648L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	protected String name;
	protected String description;
	protected Boolean active;
	
	@Enumerated(EnumType.STRING)
	protected Impact impact;

	protected Date creationDate;
	protected Date expiryDate;
	protected Date lastModifiedDate;

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID=").append(getId()).append(", Name=").append(getName()).append(",Description=").append(getDescription()).append(",Active=")
				.append(getActive()).append(",Impact=").append(getImpact()).append(",CreationDate=").append(getCreationDate()).append(",expiryDate=")
				.append(getExpiryDate()).append(",lastModifiedDate=" + getLastModifiedDate());
		return sb.toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
