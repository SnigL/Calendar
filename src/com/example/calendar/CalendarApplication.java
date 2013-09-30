package com.example.calendar;

import java.util.Date;
import java.util.logging.Logger;

import com.example.calendar.ui.MenuBarNavigation;
import com.vaadin.Application;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

public class CalendarApplication extends Application implements ClickListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PopupDateField popupDateField;
	private Button Today;
	private Button Clear;
	private TextField MCNStartValue;
	private TextField MCNEndValue;
	private Button Generate;
	
	private static Logger LOGGER = Logger.getLogger("InfoLogging");
	
	private MenuBarNavigation menubar = new MenuBarNavigation();

	@Override
	public void init() {
		buildMainLayout();	
		buildMainButtons();
		buildMainMenu();
		buildMCNLayout();
	}

	private void buildMCNLayout() {
		MCNStartValue = new TextField();
		MCNEndValue = new TextField();
		Generate = new Button("Generate");
	}

	private void buildMainMenu() {
        getMainWindow().addComponent(menubar);
		getMainWindow().addComponent(popupDateField);
		getMainWindow().addComponent(Today);
		getMainWindow().addComponent(Clear);
	}

	private void buildMainButtons() {
		Today = new Button("Today");
		Today.addListener(this);
		Clear = new Button("Clear");
		Clear.addListener(this);
	}

	private void buildMainLayout() {
		Window mainWindow = new Window("Calendar");
		popupDateField = new PopupDateField();
		popupDateField.setDateFormat("yyyy-MM-dd");
		setMainWindow(mainWindow);		
	}

	public void buttonClick(Button.ClickEvent event) {
		if (event.getButton() == Today)
		popupDateField.setValue(new Date());
		else if (event.getButton() == Clear)
			popupDateField.setValue(null);
		LOGGER.info("Clear fields");
		if (event.getButton() == Generate)
			getMainWindow().showNotification((String) MCNStartValue.getValue());
	}
}
