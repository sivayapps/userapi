/**
 * 
 */
package com.boshanam.user.core.mapping.json;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import com.boshanam.user.core.GlobalConstants;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Feb 4, 2012 1:38:23 PM
 * 
 *       Unused source to be considered for refactoring, adding it to scm just
 *       for tracking the approached used at development time.
 * 
 * @deprecated in favor of using customized Json ObjectMapper, which allows
 *             formatting dates globally in a simple way.
 */
public class JsonDateSerializer extends JsonSerializer<Date> {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(GlobalConstants.APPLICATION_DATE_TIME_FORMAT);

	@Override
	public void serialize(Date date, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {

		String formattedDate = ((DateFormat) dateFormat.clone()).format(date);

		gen.writeString(formattedDate);
	}

}
