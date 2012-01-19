package com.boshanam.user.core.model;

import java.util.Collection;
import java.util.Iterator;

public abstract class DomainObjectImpl implements DomainObject {

	public abstract Long getId();

	public abstract void setId(Long id);

	/**
	 * Tests whether ID are equal between current object and other object
	 * 
	 * @param object
	 * @throws NullPointerException
	 *             if inputs are null
	 * @throws IllegalArgumentException
	 *             if input types are different
	 * @return
	 */
	public boolean hasSameIdSameClass(Object object) {
		if (object == null)
			throw new NullPointerException("cannot compare Ids of null inputs");

		if (this.getClass().equals(object.getClass()) == false)
			throw new IllegalArgumentException("Cannot check Id equality of different types [" + this.getClass().getName() + "] and ["
					+ object.getClass().getName() + "]");

		DomainObjectImpl otherObject = (DomainObjectImpl) object;

		if (this.getId() == null || otherObject.getId() == null) {
			throw new NullPointerException("cannot compare null Ids");
		}

		return this.getId().longValue() == otherObject.getId().longValue();

	}

	public <T extends DomainObjectImpl> boolean removeFromCollection(Collection<T> collection) {
		if (collection == null) {
			throw new NullPointerException("inputs cannot be null");
		}
		Iterator<T> it = collection.iterator();
		while (it.hasNext()) {
			T element = it.next();
			if (this.hasSameIdSameClass(element) == true) {
				return collection.remove(element);
			}
		}
		return false;
	}

	public <T extends DomainObjectImpl> boolean isInCollection(Collection<T> collection) {
		if (collection == null) {
			throw new NullPointerException("inputs cannot be null");
		}
		Iterator<T> it = collection.iterator();
		while (it.hasNext()) {
			T element = it.next();
			if (this.hasSameIdSameClass(element)) {
				return true;
			}
		}
		return false;
	}
}
