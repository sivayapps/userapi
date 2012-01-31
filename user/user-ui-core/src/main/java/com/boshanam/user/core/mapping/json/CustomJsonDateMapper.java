/**
 * 
 */
package com.boshanam.user.core.mapping.json;

import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.boshanam.user.core.GlobalConstants;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Jan 29, 2012 6:35:53 PM
 * 
 */
@Component("objectMapper")
public class CustomJsonDateMapper extends ObjectMapper {

	private static Logger sLogger = LoggerFactory.getLogger(CustomJsonDateMapper.class);

	public CustomJsonDateMapper() {
		sLogger.debug("##########************** Initializing CustomJsonDateMapper ************###################");
	}

	@PostConstruct
	public void afterPropertiesSet() throws Exception {
		setDateFormat(new SimpleDateFormat(GlobalConstants.APPLICATION_DATE_TIME_FORMAT)); // ISO
		// 8601
		// Another approach but setDateFormat is deprecated on
		// SerializationConfig(), using setDateFormat on ObjectMapper
		// getSerializationConfig().setDateFormat(new
		// SimpleDateFormat("yyyy-MM-dd’T'HH:mm:ss.SZ"));
	}

}
