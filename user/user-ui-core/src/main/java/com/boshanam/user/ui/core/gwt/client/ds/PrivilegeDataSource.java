/**
 * 
 */
package com.boshanam.user.ui.core.gwt.client.ds;

import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.FieldType;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Jan 26, 2012 9:23:28 PM 
 *
 */
public class PrivilegeDataSource extends AbstractRestJsonDataSource {

	private static PrivilegeDataSource instance = null;

	public static PrivilegeDataSource getInstance() {
		if (instance == null) {
			instance = new PrivilegeDataSource("privilegeDS");
		}

		return instance;
	}

	private PrivilegeDataSource(String id) {
		super(id);
	}

	protected void init() {
		super.init();
		setJsonRecordXPath("/");
		DataSourceField idField = new DataSourceField("id", FieldType.INTEGER, "Id");
		idField.setPrimaryKey(true);
		idField.setCanEdit(false);
		DataSourceField nameField = new DataSourceTextField("name", "Name");
		DataSourceField descriptionField = new DataSourceTextField("description", "Description");
		DataSourceField activeField = new DataSourceBooleanField("active", "Active");
		DataSourceField impactField = new DataSourceTextField("impact", "Impact");
		DataSourceField creationDateField = new DataSourceDateField("creationDate", "CreationDate");
		DataSourceField expiryDate = new DataSourceDateField("expiryDate", "ExpiryDate");
		DataSourceField lastModifiedDateField = new DataSourceDateField("lastModifiedDate", "LastModifiedDate");
		setFields(idField, nameField, descriptionField, activeField, impactField, creationDateField, expiryDate, lastModifiedDateField);
	}

	@Override
	protected String getServiceRoot() {
		return "rest/privilege/";
	}

}
