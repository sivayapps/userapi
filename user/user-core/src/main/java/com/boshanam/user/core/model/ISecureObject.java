/**
 * 
 */
package com.boshanam.user.core.model;

import java.util.Date;

import com.boshanam.user.core.dto.Impact;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Jan 26, 2012 12:32:17 AM
 * 
 */
public interface ISecureObject extends IEntity {

	public String getName();

	public void setName(String name);

	public String getDescription();

	public void setDescription(String description);

	public Boolean getActive();

	public void setActive(Boolean active);

	public Impact getImpact();

	public void setImpact(Impact impact);

	public Date getCreationDate();

	public void setCreationDate(Date creationDate);

	public Date getExpiryDate();

	public void setExpiryDate(Date expiryDate);

	public Date getLastModifiedDate();

	public void setLastModifiedDate(Date lastModifiedDate);

}
