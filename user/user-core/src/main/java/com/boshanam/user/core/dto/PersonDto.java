/**
 * 
 */
package com.boshanam.user.core.dto;

import java.io.Serializable;

/**
 * @author Swetha
 * 
 */
public class PersonDto extends ObjectDto implements Serializable {

	private static final long serialVersionUID = -3518255151966938724L;
	private String name;

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
		if (super.id != null) {
			return id.hashCode();
		}
		return "".hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof PersonDto) {
			PersonDto anotherPerson = (PersonDto) obj;
			if (this.id != null) {
				return this.id.equals(anotherPerson.id);
			} else if (anotherPerson.id == null) {
				return true;
			}
		}
		return false;
	}

}
