/**
 * 
 */
package com.boshanam.user.core.util;

import java.util.Date;

import org.joda.time.DateTime;

/**
 * An util class for general date operations, such as date to string
 * conversions,
 * 
 * Incrementing/decrementing dates Adding/reducing working days Duration
 * measures etc.
 * 
 * This class uses JodaTime library
 * 
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Feb 12, 2012 2:12:40 AM
 * 
 */
public class DateUtil {

	/**
	 * Increments given number of years to the Given Date instance. Will not alter
	 * given date instance, creates and returns new date instance with modified
	 * date.
	 * 
	 * @param date
	 * @param years
	 * 
	 * @return incremented new date instance
	 */
	public static Date plusYears(Date date, int years) {

		DateTime dt = new DateTime(date);
		dt = dt.plusYears(years);

		return dt.toDate();

	}

}
