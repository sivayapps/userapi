/**
 * 
 */
package com.boshanam.user.core.mapping.util;

import org.dozer.CustomFieldMapper;
import org.dozer.classmap.ClassMap;
import org.dozer.fieldmap.FieldMap;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Jan 29, 2012 4:00:28 PM
 * 
 */
public class SkipNullAndEmptyStringFieldMapper implements CustomFieldMapper {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dozer.CustomFieldMapper#mapField(java.lang.Object,
	 * java.lang.Object, java.lang.Object, org.dozer.classmap.ClassMap,
	 * org.dozer.fieldmap.FieldMap)
	 */
	@Override
	public boolean mapField(Object source, Object destination, Object sourceFieldValue, ClassMap classMap, FieldMap fieldMapping) {
		if (sourceFieldValue == null || "".equals(sourceFieldValue.toString().trim())) {
			return true;
		}
		return false;
	}

}
