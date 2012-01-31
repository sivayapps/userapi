package com.boshanam.user.ui.core.gwt.client.ui;

import com.boshanam.user.ui.core.gwt.client.ds.PersonDataSource;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.VLayout;

public class UserApplicationView extends VLayout {

	ListGrid personGrid = new ListGrid();

	public UserApplicationView() {

		personGrid = new ListGrid();
		personGrid.setWidth100();
		personGrid.setHeight100();
		personGrid.setShowAllRecords(true);
		PersonDataSource personDataSource = PersonDataSource.getInstance();
		personDataSource.setCacheMaxAge(0);
		personGrid.setDataSource(personDataSource);
		personGrid.setAutoFetchData(true);
		personGrid.setCanEdit(true);

		final IButton addButton = new IButton("Add new Person");
		addButton.setWidth100();
		addButton.setHeight("10%");
		addButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				personGrid.addData(new ListGridRecord());
			}
		});

		VLayout vLayoutPersonGrid = new VLayout();
		vLayoutPersonGrid.setMembers(personGrid, addButton);

		setMembers(vLayoutPersonGrid);
	}

	// public void onModuleLoad() {
	//
	// final DynamicForm form = new DynamicForm();
	// final TextItem textItem = new TextItem();
	// textItem.setTitle("Name");
	// form.setFields(textItem);
	// final IButton button = new IButton("Hello");
	//
	// button.addClickHandler(new ClickHandler() {
	// public void onClick(ClickEvent event) {
	// String name = textItem.getValue().toString();
	// SC.say("Hello " + name);
	// }
	// });

	// HLayout hLayoutForm = new HLayout();
	// hLayoutForm.setMembers(form, button);

	// VLayout vLayout = new VLayout();
	// vLayout.setMembers(hLayoutForm, hLayoutPersonGrid);

	// vLayout.show();

	// RootPanel.get("formContainer").add(form);
	// RootPanel.get("buttonContainer").add(button);
	// RootPanel.get("personEditor").add(personGrid);
	//
	// RootPanel.get("addPerson").add(addButton);

	// }

}
