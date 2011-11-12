package com.boshanam.user.ui.gwt.client.ui;

import com.boshanam.user.ui.core.gwt.client.ui.UserApplicationView;
import com.google.gwt.core.client.EntryPoint;

public class UserUi implements EntryPoint {

	public void onModuleLoad() {
		UserApplicationView view = new UserApplicationView();

		view.show();

	}

}
