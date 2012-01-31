/**
 * 
 */
package com.boshanam.user.ui.core.gwt.client.ds;

import com.boshanam.user.ui.core.gwt.client.GlobalClientConstants;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceEnumField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

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
		DataSourceIntegerField idField = new DataSourceIntegerField("id", "Id");
		idField.setPrimaryKey(true);
		idField.setRequired(true);
		idField.setCanEdit(false);
		DataSourceTextField nameField = new DataSourceTextField("name", "Name");
		DataSourceTextField descriptionField = new DataSourceTextField("description", "Description");
		DataSourceBooleanField activeField = new DataSourceBooleanField("active", "Active");
		DataSourceEnumField impactField = new DataSourceEnumField("impact", "Impact");
		impactField.setValueMap(GlobalClientConstants.IMPACT_ENUM_VALUES);

		DataSourceDateTimeField creationDateField = new DataSourceDateTimeField("creationDate", "CreationDate");
		creationDateField.setCanSave(false);
		DataSourceDateField expiryDate = new DataSourceDateField("expiryDate", "ExpiryDate");
		DataSourceDateField lastModifiedDateField = new DataSourceDateField("lastModifiedDate", "LastModifiedDate");
		setFields(idField, nameField, descriptionField, activeField, impactField, creationDateField, expiryDate, lastModifiedDateField);
	}

	@Override
	protected String getServiceRoot() {
		return "rest/privilege/";
	}

}
