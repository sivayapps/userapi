package com.boshanam.user.ui.gwt.client.ui;

import com.boshanam.user.ui.core.gwt.client.ui.UserApplicationView;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class UserUi implements EntryPoint {

	public void onModuleLoad() {
		UserApplicationView view = new UserApplicationView();

		// hide the animated 'loading.gif'
		RootPanel.get("loading").setVisible(false);
		
		//view.show();
		RootPanel.get().add(view);

	}

}
