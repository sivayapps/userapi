/**
 * 
 */
package com.boshanam.user.ui.core.gwt.client;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Jan 28, 2012 10:15:55 PM
 * 
 */
public interface GlobalClientConstants {

	/**
	 * These values are the Enum types defined under
	 * com.boshanam.user.core.dto.Impact As gwt can't use class files and sources
	 * not in client package, I redefined those enum's as constants here. Any
	 * changes to Impact enum type should be updated here.
	 */
	public static final String[] IMPACT_ENUM_VALUES = { "Low", "Medium", "High", "Severe", "Worse" };

	public static final String DATE_FORMAT = "yyyyMMddHHmmssZ";
	public static final String DATE_FORMAT_NO_TIME_ZONE = "yyyyMMddHHmmss";

}
