/**
 * 
 */
package com.boshanam.user.autowired.core.mapping.jackson;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

import com.boshanam.user.core.mapping.json.CustomJsonObjectMapper;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Feb 1, 2012 11:56:18 PM
 * 
 * @deprecated As Spring 3.1.0.RELEASE supports customizing configuration of
 *             MessageConverters through the element
 *             "&lt;mvc:annotation-driven/&gt;" through below configuration
 * 
 *             &lt;mvc:annotation-driven&gt; <br>
 *             &lt;mvc:message-converters&gt; <br>
 * <br>
 *             &lt;!-- Jackson mapping config to set global date format, this <br>
 *             config is possible only from spring 3.1.0.RELEASE --&gt; <br>
 * <br>
 *             &lt;bean class=&quot;org.springframework.http.converter.json.
 *             MappingJacksonHttpMessageConverter&quot;&gt; <br>
 *             &lt;property name=&quot;objectMapper&quot;
 *             ref=&quot;jacksonObjectMapper&quot; /&gt; <br>
 *             &lt;/bean&gt; <br>
 *             &lt;/mvc:message-converters&gt; <br>
 *             &lt;/mvc:annotation-driven&gt;
 */
// @Component //not needed now, (unused source, will be removed later)
public class JacksonFix {

	private static Logger sLogger = LoggerFactory.getLogger(JacksonFix.class);

	// this will exist due to the <mvc:annotation-driven/> bean
	@Autowired
	private AnnotationMethodHandlerAdapter annotationMethodHandlerAdapter;

	@Autowired
	private CustomJsonObjectMapper objectMapper;

	@Autowired
	private ApplicationContext applicationContext;

	@PostConstruct
	public void init() {
		boolean jacksonCustomObjectMapperInitialized = false;
		HttpMessageConverter<?>[] messageConverters = annotationMethodHandlerAdapter.getMessageConverters();
		for (HttpMessageConverter<?> messageConverter : messageConverters) {
			if (messageConverter instanceof MappingJacksonHttpMessageConverter) {
				MappingJacksonHttpMessageConverter m = (MappingJacksonHttpMessageConverter) messageConverter;
				m.setObjectMapper(objectMapper);
				sLogger.debug("##########************** JacksonFix Initialized CustomJsonObjectMapper ************###################");
				jacksonCustomObjectMapperInitialized = true;
			}
		}
		if (!jacksonCustomObjectMapperInitialized) {
			HttpMessageConverter<?>[] temp = new HttpMessageConverter<?>[messageConverters.length + 1];
			int i = 0;
			for (HttpMessageConverter<?> hmc : messageConverters) {
				temp[i++] = hmc;
			}
			MappingJacksonHttpMessageConverter tempMJackConv = new MappingJacksonHttpMessageConverter();
			tempMJackConv.setObjectMapper(objectMapper);
			temp[i++] = tempMJackConv;
			annotationMethodHandlerAdapter.setMessageConverters(temp);
		}

	}

	public void setAnnotationMethodHandlerAdapter(AnnotationMethodHandlerAdapter annotationMethodHandlerAdapter) {
		this.annotationMethodHandlerAdapter = annotationMethodHandlerAdapter;
	}

	public void setObjectMapper(CustomJsonObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	/**
	 * @return the applicationContext
	 */
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * @param applicationContext
	 *          the applicationContext to set
	 */
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

}
