package com.boshanam.user.ui.core.gwt.client.ds;

import java.util.HashMap;
import java.util.Map;

import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.types.DSDataFormat;

public abstract class AbstractRestJsonDataSource extends AbstractRestDataSource {

	public AbstractRestJsonDataSource(String id) {
		super(id);
	}

	protected void init() {

		setDataFormat(DSDataFormat.JSON);

		// CUSTOM
		final Map<String, String> headers = new HashMap<String, String>();
		headers.put("Accept", "application/json");

		// TODO remove
		// headers.put ("myheader", "foo");
		// headers.put ("Pragma", "no-cache");
		// headers.put ("Cache-Control", "no-cache, no-store, must-revalidate");

		final DSRequest request = new DSRequest();
		request.setHttpHeaders(headers);
		setRequestProperties(request);
		// CUSTOM

	}

}