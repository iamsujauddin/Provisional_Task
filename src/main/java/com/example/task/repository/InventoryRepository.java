package com.example.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.task.entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer>{

	@Query(value="SELECT * FROM db_example.inventory where itemId=?;",nativeQuery = true)
	Inventory updateItemStatus(int itemId);

}
