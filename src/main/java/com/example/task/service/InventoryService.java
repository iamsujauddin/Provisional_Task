package com.example.task.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.task.entity.Inventory;
import com.example.task.repository.InventoryRepository;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	public Inventory addProduct(Inventory inventory) throws Exception {
		Inventory item = new Inventory();
		try {
			item.setItemName(inventory.getItemName());
			item.setItemOwner(inventory.getItemOwner());
			item.setStatus("ACTIVATE");
			return inventoryRepository.save(item);
		} catch (Exception e) {
			throw new Exception("Item could not be added Please connect Sysadm");
		}
	}

	public Inventory updateStatus(int itemId) throws Exception {
		Inventory inventory = null;
		try {
			inventory = inventoryRepository.updateItemStatus(itemId);
			if (inventory.getStatus().equalsIgnoreCase("ACTIVATE")) {
				inventory.setStatus("DEACTIVATE");
			}
			inventoryRepository.save(inventory);
		} catch (Exception e) {
			throw new Exception("Status could not be update");
		}
		return inventory;
	}

	public ArrayList<Inventory> getAllItems() throws Exception {
		try {
			return (ArrayList<Inventory>) inventoryRepository.findAll();
		} catch (Exception e) {
			throw new Exception("Data could not be fectched please connect sysadm");
		}
	}

	public void deleteItem(int itemId) {
		inventoryRepository.deleteById(itemId);
	}

}
