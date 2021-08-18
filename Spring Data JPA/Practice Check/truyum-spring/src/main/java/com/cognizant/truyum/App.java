package com.cognizant.truyum;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;
import com.cognizant.truyum.util.DateUtil;

@SpringBootApplication
public class App {

	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
	private static MenuItemService menuItemService;

	public static void main(String[] args) throws ParseException {
		ApplicationContext context = SpringApplication.run(App.class, args);
		LOGGER.info("Application Started........");
		menuItemService = context.getBean(MenuItemService.class);
		testGetMenuItem();
	}

	private static void testGetMenuItemListAdmin() {
		LOGGER.info("START");
		List<MenuItem> items = menuItemService.getMenuItemListAdmin();
		LOGGER.debug("Menu Items = {}", items);
		LOGGER.info("END");
	}

	private static void testGetMenuItemListCustomer() {
		LOGGER.info("START");
		List<MenuItem> items = menuItemService.getMenuItemListCustomer();
		LOGGER.debug("Menu Items = {}", items);
		LOGGER.info("END");
	}

	private static void testGetMenuItem() {
		LOGGER.info("START");
		MenuItem menu_item = menuItemService.getMenuItem(1);
		LOGGER.debug("Menu item = {}", menu_item);
		LOGGER.info("END");
	}

	private static void testEditMenuItem() throws ParseException {
		LOGGER.info("START");
		MenuItem newMenuItem = new MenuItem(1, "Big Sandwhich", (float) 100.0, true,
				DateUtil.convertToDate("20/03/2017"), "Main Course", true);
		menuItemService.modifyMenuItem(newMenuItem);
		MenuItem modifiedItem = menuItemService.getMenuItem(1);
		LOGGER.debug("Modified menu Item ={}", modifiedItem);
		LOGGER.info("END");
	}

}
