package com.boshanam.user.core.model;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Jan 22, 2012 6:40:46 PM
 * 
 */
public interface IDomainObject<ID extends Serializable> {

	public ID getId();

	public void setId(ID id);

	public boolean hasSameIdSameClass(Object object);

	public <T extends DomainObjectImpl<ID>> boolean removeFromCollection(Collection<T> collection);

	public <T extends DomainObjectImpl<ID>> boolean isInCollection(Collection<T> collection);

}
