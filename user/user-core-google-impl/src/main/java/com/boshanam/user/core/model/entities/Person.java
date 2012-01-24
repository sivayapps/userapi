/**
 * 
 */
package com.boshanam.user.core.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.boshanam.user.core.model.DomainObjectImpl;
import com.boshanam.user.core.model.IPerson;

/**
 * @author Swetha
 * 
 */

@Entity
public class Person extends DomainObjectImpl implements IPerson {

	private static final long serialVersionUID = -3518255151966938724L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

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

	public String toString() {
		return "( id : " + this.id + ", Name: " + this.name + ")";
	}

	@Override
	public int hashCode() {
		if (this.id != null) {
			return id.hashCode();
		}
		// if two instances having null id, they will have same hash code :-)
		return "".hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Person) {
			Person anotherPerson = (Person) obj;
			if (this.id != null) {
				return this.id.equals(anotherPerson.id);
			} else if (anotherPerson.id == null) {
				return true;
			}
		}
		return false;
	}

}
