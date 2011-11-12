package com.boshanam.user.ui.core.gwt.client.ui;

import com.boshanam.user.ui.core.gwt.client.ds.PersonDataSource;
import com.google.gwt.core.client.EntryPoint;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class UserUi implements EntryPoint {
	
	public void onModuleLoad() {
		
		final DynamicForm form = new DynamicForm();
		final TextItem textItem = new TextItem();
		textItem.setTitle("Name");
		form.setFields(textItem);
		final IButton button = new IButton("Hello");
		
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				String name = textItem.getValue().toString();
				SC.say("Hello " + name);
			}
		});
		

		final ListGrid personGrid = new ListGrid(); 
        personGrid.setWidth(500);  
        personGrid.setHeight(224);  
        personGrid.setShowAllRecords(true); 
        PersonDataSource personDataSource = PersonDataSource.getInstance();
        personDataSource.setCacheMaxAge(10);
        personGrid.setDataSource(personDataSource);  
        personGrid.setAutoFetchData(true);  
        personGrid.setCanEdit(true);  
  
//        personGrid.draw(); 
		
        final IButton addButton = new IButton("Add new Person");
        addButton.setWidth(150);
        addButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
            	personGrid.addData(new ListGridRecord());
            }
        });
        
        HLayout hLayoutForm = new HLayout();
        hLayoutForm.setMembers(form, button);
        
        HLayout hLayoutPersonGrid = new HLayout();
        hLayoutPersonGrid.setMembers(personGrid, addButton);
        
        VLayout vLayout = new VLayout();
        vLayout.setMembers(hLayoutForm, hLayoutPersonGrid);
        
        vLayout.show();
        
		// RootPanel.get("formContainer").add(form);
		// RootPanel.get("buttonContainer").add(button);
		// RootPanel.get("personEditor").add(personGrid);
		//
		// RootPanel.get("addPerson").add(addButton);
		
	}


}
