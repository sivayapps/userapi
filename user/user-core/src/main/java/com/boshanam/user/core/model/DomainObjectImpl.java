package com.boshanam.user.core.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

public abstract class DomainObjectImpl<ID extends Serializable> implements IDomainObject<ID> {

	public abstract ID getId();

	public abstract void setId(ID id);

	/**
	 * Tests whether ID are equal between current object and other object
	 * 
	 * @param object
	 * @throws NullPointerException
	 *           if inputs are null
	 * @throws IllegalArgumentException
	 *           if input types are different
	 * @return
	 */
	public boolean hasSameIdSameClass(Object object) {
		if (object == null)
			throw new NullPointerException("cannot compare Ids of null inputs");

		if (this.getClass().equals(object.getClass()) == false)
			throw new IllegalArgumentException("Cannot check Id equality of different types [" + this.getClass().getName() + "] and ["
					+ object.getClass().getName() + "]");

		@SuppressWarnings("unchecked")
		DomainObjectImpl<Long> otherObject = (DomainObjectImpl<Long>) object;

		if (this.getId() == null || otherObject.getId() == null) {
			throw new NullPointerException("cannot compare null Ids");
		}

		return this.getId().equals(otherObject.getId());

	}

	public <T extends DomainObjectImpl<ID>> boolean removeFromCollection(Collection<T> collection) {
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

	public <T extends DomainObjectImpl<ID>> boolean isInCollection(Collection<T> collection) {
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
