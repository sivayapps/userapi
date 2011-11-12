/**
 * 
 */
package com.boshanam.user.domain;

import java.io.Serializable;

/**
 * @author Swetha
 * 
 */
public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3518255151966938724L;
	private Integer id;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "[ id : " + this.id + ", Name: " + this.name + "]";
	}

	@Override
	public int hashCode() {
		if(this.id != null ) {
			return id.hashCode();
		}
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if(this.id != null) {
			return this.id.equals(obj);
		}
		return super.equals(obj);
	}
	
	

}
