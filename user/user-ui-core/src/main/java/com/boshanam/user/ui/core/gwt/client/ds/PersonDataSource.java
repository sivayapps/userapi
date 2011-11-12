/**
 * 
 */
package com.boshanam.user.ui.core.gwt.client.ds;

import java.util.HashMap;
import java.util.Map;

import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.FieldType;

/**
 * @author Swetha
 * 
 */
public class PersonDataSource extends AbstractRestDataSource {

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

		setDataFormat(DSDataFormat.JSON);
		
		
		//CUSTOM
	    final Map<String, String> headers = new HashMap<String, String> ();
	    headers.put ("Accept", "application/json");
	    
	    //TODO remove
	    headers.put ("myheader", "foo");
	    headers.put ("Pragma", "no-cache");
	    headers.put ("Cache-Control", "no-cache, no-store, must-revalidate");
			
	    final DSRequest request = new DSRequest ();
	    request.setHttpHeaders (headers);
	    setRequestProperties (request);
	    //CUSTOM
	    
		setJsonRecordXPath("/");

		DataSourceField idField = new DataSourceField("id", FieldType.INTEGER, "ID");
		idField.setPrimaryKey(true);
		idField.setCanEdit(false);
		DataSourceField nameField = new DataSourceField("name", FieldType.TEXT,	"Name");

		setFields(idField, nameField);
	}

	@Override
	protected String getServiceRoot() {
		return "rest/person/";
	}

}
