/**
 * 
 */
package com.boshanam.user.core.model;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Mar 21, 2012 11:56:44 PM
 * 
 */
public interface IGrantedAuthority<T> extends IEntity {

	public T getGrant();

	public void setGrant(T grant);

}
