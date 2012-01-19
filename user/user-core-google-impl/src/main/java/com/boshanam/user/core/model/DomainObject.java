package com.boshanam.user.core.model;

import java.util.Collection;

public interface DomainObject {

	public Long getId();

	public void setId(Long id);

	public boolean hasSameIdSameClass(Object object);

	public <T extends DomainObjectImpl> boolean removeFromCollection(Collection<T> collection);

	public <T extends DomainObjectImpl> boolean isInCollection(Collection<T> collection);

}
