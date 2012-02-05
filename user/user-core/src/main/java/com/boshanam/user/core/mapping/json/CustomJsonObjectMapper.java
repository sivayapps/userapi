/**
 * 
 */
package com.boshanam.user.core.mapping.json;

import java.text.SimpleDateFormat;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.boshanam.user.core.GlobalConstants;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Jan 29, 2012 6:35:53 PM
 * 
 */
public class CustomJsonObjectMapper extends ObjectMapper {

	private static Logger sLogger = LoggerFactory.getLogger(CustomJsonObjectMapper.class);

	public CustomJsonObjectMapper() {
		sLogger.info("*** Initializing CustomJsonObjectMapper ***");

		configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);

		sLogger.info("*** JSON_DATE_FORMAT Date format '{}' {}", GlobalConstants.JSON_DATE_FORMAT, "set to jackson ***");

		// getSerializationConfig().withDateFormat(new
		// SimpleDateFormat(GlobalConstants.APPLICATION_DATE_TIME_FORMAT));

		// using setDateFormat on ObjectMapper
		setDateFormat(new SimpleDateFormat(GlobalConstants.JSON_DATE_FORMAT));
	}

}
