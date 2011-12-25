/**
 * 
 */
package com.boshanam.user.ui.core.gwt.client.ds;

import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.FieldType;

/**
 * @author Swetha
 * 
 */
public class PersonDataSource extends AbstractRestJsonDataSource {

	private static PersonDataSource instance = null;

	public static PersonDataSource getInstance() {
		if (instance == null) {
			instance = new PersonDataSource("personEditDS");
		}

		return instance;
	}

	private PersonDataSource(String id) {
		super(id);
	}

	protected void init() {
		super.init();
		setJsonRecordXPath("/");
		DataSourceField idField = new DataSourceField("id", FieldType.INTEGER, "Id");
		idField.setPrimaryKey(true);
		idField.setCanEdit(false);
		DataSourceField nameField = new DataSourceTextField("name", "Name");
		setFields(idField, nameField);
	}

	@Override
	protected String getServiceRoot() {
		return "rest/person/";
	}

}
