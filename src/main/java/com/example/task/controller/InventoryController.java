package com.example.task.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.task.entity.Inventory;
import com.example.task.service.InventoryService;

@RestController
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	@PostMapping("/add")
	public Inventory addItem(@RequestBody Inventory inventory) throws Exception {
		return inventoryService.addProduct(inventory);
	}

	@PutMapping("/update/{itemId}")
	public Inventory updateStatus(@PathVariable int itemId) throws Exception {
		return inventoryService.updateStatus(itemId);

	}

	@GetMapping("/getAll")
	public ArrayList<Inventory> getAllItem() throws Exception {
		return inventoryService.getAllItems();
	}

	@DeleteMapping("/delete/{itemId}")
	public void deleteItem(@PathVariable int itemId) {
		inventoryService.deleteItem(itemId);
	}

}
