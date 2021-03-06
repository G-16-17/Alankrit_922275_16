package com.cognizant.truyum.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.repository.MenuItemRepository;

@Service
public class MenuItemService {

	@Autowired
	MenuItemRepository menuItemRepository;

	@Transactional
	public List<MenuItem> getMenuItemListAdmin() {

		return menuItemRepository.findAll();
	}

	@Transactional
	public List<MenuItem> getMenuItemListCustomer(){
		return menuItemRepository.findByActiveNotAndDateOfLaunchBefore(false, new Date());
	}

	@Transactional
	public MenuItem getMenuItem(int id) {
		Optional<MenuItem> itemList = menuItemRepository.findById(id);
		MenuItem item = itemList.get();
		return item;
	}

	@Transactional
	public void modifyMenuItem(MenuItem item) {
		menuItemRepository.save(item);
	}
}
