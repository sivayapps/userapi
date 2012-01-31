/**
 * 
 */
package com.boshanam.user.core.mapping.util;

import org.dozer.DozerBeanMapper;
import org.dozer.MappingException;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Jan 29, 2012 2:22:19 PM
 * 
 */
public class DozerMappingUtil {

	private DozerBeanMapper dozerMapper;

	public DozerMappingUtil(DozerBeanMapper dozerMapperInstance) {
		this.dozerMapper = dozerMapperInstance;
		this.dozerMapper.setCustomFieldMapper(new SkipNullAndEmptyStringFieldMapper());
	}

	/**
	 * {@inheritDoc}
	 */
	public void map(Object source, Object destination, String mapId) throws MappingException {
		getDozerMapper().map(source, destination, mapId);
	}

	/**
	 * {@inheritDoc}
	 */
	public <T> T map(Object source, Class<T> destinationClass, String mapId) throws MappingException {
		return getDozerMapper().map(source, destinationClass, mapId);
	}

	/**
	 * {@inheritDoc}
	 */
	public <T> T map(Object source, Class<T> destinationClass) throws MappingException {
		return getDozerMapper().map(source, destinationClass);
	}

	/**
	 * {@inheritDoc}
	 */
	public void map(Object source, Object destination) throws MappingException {
		getDozerMapper().map(source, destination);
	}

	/**
	 * @return the dozerMapper
	 */
	public DozerBeanMapper getDozerMapper() {
		return dozerMapper;
	}

	/**
	 * @param dozerMapper
	 *          the dozerMapper to set
	 */
	public void setDozerMapper(DozerBeanMapper dozerMapper) {
		this.dozerMapper = dozerMapper;
	}

}
