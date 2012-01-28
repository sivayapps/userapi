/**
 * 
 */
package com.boshanam.user.ui.core.gwt.client.ui;

import com.boshanam.user.ui.core.gwt.client.ds.PrivilegeDataSource;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * @author Siva
 * @Email: shiva.forums@gmail.com
 * @Date Jan 28, 2012 7:46:14 PM
 * 
 */
public class PrivilegeGridView extends VLayout {

	ListGrid privilegeGrid = new ListGrid();

	public PrivilegeGridView() {
		privilegeGrid.setHeight("*");
		privilegeGrid.setWidth("*");
		privilegeGrid.setShowAllRecords(true);
		PrivilegeDataSource privilegeDataSource = PrivilegeDataSource.getInstance();
		privilegeDataSource.setCacheMaxAge(0);
		privilegeGrid.setDataSource(privilegeDataSource);
		privilegeGrid.setAutoFetchData(true);
		privilegeGrid.setCanEdit(true);

		final IButton addButton = new IButton("Add new Privilege");
		addButton.setWidth("*");
		addButton.setHeight("10%");
		addButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				privilegeGrid.addData(new ListGridRecord());
			}
		});

		VLayout vLayoutPrivilegeGrid = new VLayout();
		vLayoutPrivilegeGrid.setMembers(privilegeGrid, addButton);

		setMembers(vLayoutPrivilegeGrid);
	}

}
