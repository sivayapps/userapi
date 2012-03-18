/**
 * 
 */
package com.boshanam.user.core;

import org.joda.time.DateTimeZone;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Jan 29, 2012 8:54:04 PM
 * 
 */
public interface GlobalConstants {

	public static final String APPLICATION_DATE_TIME_FORMAT = "yyyyMMddHHmmssZ";// "EEE MMM dd HH:mm:ss z yyyy";

	// XML Schema format DateTime Format, will be acceptable and recognized by
	// SmartGwt when sending date and DateTime as XML or JSON
	public static final String JSON_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	public static final String APPLICATION_TIME_ZONE_JODA_FORMAT = DateTimeZone.UTC.getID();

	public static final String APPLICATION_TIME_ZONE_JDK_FORMAT = "UTC";

}
