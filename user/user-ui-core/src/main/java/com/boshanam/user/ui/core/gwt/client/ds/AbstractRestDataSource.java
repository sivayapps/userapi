/**
 * 
 */
package com.boshanam.user.ui.core.gwt.client.ds;

import java.util.Date;
import java.util.Map;

import com.boshanam.user.ui.core.gwt.client.GlobalClientConstants;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.http.client.URL;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.OperationBinding;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RestDataSource;
import com.smartgwt.client.types.DSOperationType;
import com.smartgwt.client.types.DSProtocol;
import com.smartgwt.client.util.JSON;

/**
 * Base implementation of REST data source to be extended by most other specific
 * data sources of SmartGwt.
 * 
 * Specifies JSON as underlying transport data format.
 * 
 * Uses URL encoding to submit request parameters in case of http PUT, as most
 * servers can not identify posted parameters of PUT request.
 * 
 * @author Sivakumar Y
 * @Email: shiva.forums@gmail.com
 * @Date Dec 4, 2011 7:58:43 PM
 * 
 */
public abstract class AbstractRestDataSource extends RestDataSource {
	public AbstractRestDataSource(String id) {
		setID(id);
		setClientOnly(false);

		// set up FETCH to use GET requests
		OperationBinding fetch = new OperationBinding();
		fetch.setOperationType(DSOperationType.FETCH);
		DSRequest fetchProps = new DSRequest();
		fetchProps.setHttpMethod("GET");
		fetch.setRequestProperties(fetchProps);

		// set up ADD to use POST requests
		OperationBinding add = new OperationBinding();
		add.setOperationType(DSOperationType.ADD);
		add.setDataProtocol(DSProtocol.POSTPARAMS);

		// set up UPDATE to use PUT
		OperationBinding update = new OperationBinding();
		update.setOperationType(DSOperationType.UPDATE);
		DSRequest updateProps = new DSRequest();

		updateProps.setHttpMethod("PUT");
		update.setRequestProperties(updateProps);

		// set up REMOVE to use DELETE
		OperationBinding remove = new OperationBinding();
		remove.setOperationType(DSOperationType.REMOVE);
		DSRequest removeProps = new DSRequest();
		removeProps.setHttpMethod("DELETE");
		remove.setRequestProperties(removeProps);

		// apply all the operational bindings
		setOperationBindings(fetch, add, update, remove);

		init();
	}

	@Override
	protected Object transformRequest(DSRequest request) {

		super.transformRequest(request);

		// now post process the request for our own means
		postProcessTransform(request);

		JavaScriptObject jso = request.getData();
		String s1 = JSON.encode(jso);
		return s1;

		// don't return data, it is causing to post data to server again,
		// causing the actual updated vale is getting duplicated as comma
		// Separated values, i.e, if the updated value is "Sai", it will be
		// treated by GAE (Google) server as "Sai,Sai". Because GAE is smart
		// enough to recognize PUT parameters in addition to URL encoded
		// parameters. No problem found with maven jetty server. To make this
		// portable to GAE and also other servers, We are relying only on URL
		// encoding to submit parameters in http PUT request.
		// return request.getData();
		// return "";// request.getData();
	}

	/*
	 * Implementers can override this method to create a different override.
	 */
	@SuppressWarnings("rawtypes")
	protected void postProcessTransform(DSRequest request) {
		StringBuilder url = new StringBuilder(getServiceRoot());

		Map dataMap = request.getAttributeAsMap("data");
		if (request.getOperationType() == DSOperationType.REMOVE) {
			// in case of remove, append the primary key
			url.append(getPrimaryKeyProperty()).append("/").append(dataMap.get(getPrimaryKeyProperty()));
		} else if (request.getOperationType() == DSOperationType.UPDATE) {
			appendParameters(url, request);
		}
		// Replace + with '%2B' otherwise it will be encoded to space
		String urlEncoded = URL.encode(url.toString().replaceAll("\\+", "%2B"));
		// % from above will get encoded to '%252' converting it back to '%' which
		// creates '%2B' equal to '+' sign, other wise it will be treated by server
		// as '%2B' instead of '+'
		urlEncoded = urlEncoded.replaceAll("%252B", "%2B");
		request.setActionURL(urlEncoded);
	}

	/*
	 * This simply appends parameters that have changed to the URL so that PUT
	 * requests go through successfully. This is usually necessary because when
	 * smart GWT updates a row using a form, it sends the data as form parameters.
	 * Most servers cannot understand this and will simply disregard the form data
	 * sent to the server via PUT. So we need to transform the form data into URL
	 * parameters.
	 */
	@SuppressWarnings("rawtypes")
	protected void appendParameters(StringBuilder url, DSRequest request) {
		Map dataMap = request.getAttributeAsMap("data");
		Record oldValues = request.getOldValues();
		boolean paramsAppended = false;

		if (!dataMap.isEmpty()) {
			url.append("?");
		}

		for (Object keyObj : dataMap.keySet()) {
			String key = (String) keyObj;
			// TODO currently causing issues when we transmit only modified values.
			// as these values will be directly mapped to DTO beans by spring, and
			// there is no way to identify modified values (checking null is not
			// useful as in case of setting empty value(removing values) to columns
			// also send null to server)
			// only append those values that changed or are primary keys
			if (!dataMap.get(key).equals(oldValues.getAttribute(key)) || isPrimaryKey(key)) {

				Object val = dataMap.get(key);
				if (key.toLowerCase().indexOf("date") >= 0 || key.toLowerCase().indexOf("datetime") >= 0) {
					// It is date handle it separately
					DateTimeFormat dateFormatter = DateTimeFormat.getFormat(GlobalClientConstants.DATE_FORMAT);
					// dateFormatter.format(getAttributeAsDate("OrderDate "));
					// ((Date) val).
					val = dateFormatter.format((Date) val);
				}
				url.append(key).append('=').append(val).append('&');
				paramsAppended = true;
			}
		}

		if (paramsAppended) {
			// delete the last '&'
			url.deleteCharAt(url.length() - 1);
		}
	}

	public boolean isPrimaryKey(String property) {
		return getPrimaryKeyProperty().equalsIgnoreCase(property);
	}

	/*
	 * The implementer can override this to change the name of the primary key
	 * property.
	 */
	protected String getPrimaryKeyProperty() {
		return "id";
	}

	protected abstract String getServiceRoot();

	protected abstract void init();

}
