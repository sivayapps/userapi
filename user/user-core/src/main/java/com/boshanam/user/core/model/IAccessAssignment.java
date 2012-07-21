/**
 * 
 */
package com.boshanam.user.core.model;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Mar 22, 2012 9:36:35 PM
 * 
 */
public interface IAccessAssignment<T> extends IEntity {

	Long accessId = null;

	public Long getAccessId();

	public void setAccessId(Long accessId);

}
