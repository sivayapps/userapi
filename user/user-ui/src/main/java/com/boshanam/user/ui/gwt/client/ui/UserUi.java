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
		Window.setMargin("0px");
//		com.smartgwt.client.util.DateUtil
//		DateUtil.
		
//		DateUtil.setDefaultDisplayTimezone("+00:00");
//    DateDisplayFormatter dateFormater = new DateDisplayFormatter() {
//      @Override
//      public String format(Date date) {
//          if (date == null) return null;
//          DateTimeFormat dateFormatter = DateTimeFormat.getFormat("dd.MM.yyyy");
//          return dateFormatter.format(date);
//      }
//  };
//  DateUtil.setShortDatetimeDisplayFormatter(dateFormater);
		// DateUtil.setDateInputFormatter(new DateInputFormatter()
		// {
		// @Override
		// public Date parse(String dateString) {
		// final DateTimeFormat dateFormatter =
		// DateTimeFormat.getFormat("dd.MM.yyyy");
		// Date date = dateFormatter.parse(dateString);
		// return date;
		// }
		// });
  
  
  
  
  
  
  
  
  
  
  
		
		UserApplicationView personView = new UserApplicationView();
		personView.setWidth("40%");
		personView.setHeight100();
		PrivilegeGridView privilegeGridView = new PrivilegeGridView();
		privilegeGridView.setWidth("*");
		privilegeGridView.setHeight100();

		HLayout layout = new HLayout();
		layout.setWidth100();
		layout.setHeight100();
		layout.setMembers(personView, privilegeGridView);
		// hide the animated 'loading.gif'
		RootPanel.get("loading").setVisible(false);

		// view.show();
		RootPanel.get().add(layout);
		// RootPanel.get("smartGwtContainer").add(personView);
		// RootPanel.get("privilegeSmartGwtContainer").add(privilegeGridView);

	}

}
