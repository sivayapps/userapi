package com.boshanam.user.core.dto;

import java.io.Serializable;

/**
 * 
 * Level of severity of the objects used in security package. This enumerations
 * are used in client ui generation. So any modifications here should need to be
 * updated in those classes. Below classes are using the enumeration names
 * declared in this class, so if there are any changes in enum names or types
 * should be updated in below classes as well, due gwt dependency on sources i
 * am not directly using this class in gwt client code for ui .
 * 
 * com.boshanam.user.ui.core.gwt.client.GlobalClientConstants
 * 
 * @author Sivakumar Y
 * @Email: shiva.forums@gmail.com
 * @Date Dec 13, 2011 10:30:41 PM
 * 
 */
public enum Impact implements Serializable {

	Low, Medium, High, Severe, Worse;

	public static String[] stringValues() {
		Impact[] values = values();
		String[] strValues = new String[values.length];
		int i = 0;
		for (Impact impact : values) {
			strValues[i] = impact.name();
		}
		return strValues;
	}
}
