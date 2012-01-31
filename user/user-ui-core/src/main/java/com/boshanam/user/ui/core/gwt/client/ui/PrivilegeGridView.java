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
import com.smartgwt.client.widgets.layout.HLayout;
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
		privilegeGrid.setHeight100();
		privilegeGrid.setWidth100();
		privilegeGrid.setShowAllRecords(true);
		PrivilegeDataSource privilegeDataSource = PrivilegeDataSource.getInstance();
		privilegeDataSource.setCacheMaxAge(0);
		privilegeGrid.setDataSource(privilegeDataSource);
		privilegeGrid.setAutoFetchData(true);
		privilegeGrid.setCanEdit(true);

		final IButton addButton = new IButton("Add new Privilege");
		addButton.setWidth("50%");
		addButton.setHeight100();
		addButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				privilegeGrid.addData(new ListGridRecord());
			}
		});
		final IButton delButton = new IButton("Delete Privilege");
		delButton.setWidth("50%");
		delButton.setHeight100();
		delButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				privilegeGrid.removeSelectedData();
			}
		});
		HLayout buttonPanel = new HLayout();
		buttonPanel.setHeight("10%");
		buttonPanel.setWidth100();
		buttonPanel.setMembers(addButton, delButton);
		VLayout vLayoutPrivilegeGrid = new VLayout();
		vLayoutPrivilegeGrid.setMembers(privilegeGrid, buttonPanel);

		setMembers(vLayoutPrivilegeGrid);
	}

}
