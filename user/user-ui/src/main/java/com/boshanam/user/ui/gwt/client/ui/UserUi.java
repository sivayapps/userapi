package com.boshanam.user.ui.gwt.client.ui;

import com.boshanam.user.ui.core.gwt.client.ui.PrivilegeGridView;
import com.boshanam.user.ui.core.gwt.client.ui.UserApplicationView;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.widgets.layout.HLayout;

public class UserUi implements EntryPoint {

	public void onModuleLoad() {

		Window.enableScrolling(false);
		Window.setMargin("10px");

		UserApplicationView personView = new UserApplicationView();
		personView.setWidth("50%");
		personView.setHeight100();
		PrivilegeGridView privilegeGridView = new PrivilegeGridView();
		privilegeGridView.setWidth("50%");
		privilegeGridView.setHeight100();

		HLayout layout = new HLayout();
		layout.setMembers(personView, privilegeGridView);
		// hide the animated 'loading.gif'
		RootPanel.get("loading").setVisible(false);

		// view.show();
		RootPanel.get().add(personView);
		// RootPanel.get("smartGwtContainer").add(personView);
		// RootPanel.get("privilegeSmartGwtContainer").add(privilegeGridView);

	}

}
