package com.sadapay.sadaparcel.ItemsManagementAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemsManagementController {

    @Autowired
    private ItemsManagementService itemsManagementService;

    @GetMapping("/api/test")
    public String testAPI() {
        return "Test success 200";
    }

    // GET request to fetch all items
    @GetMapping("/api/items-management/fetch")
    public ResponseEntity<List<ItemsManagementLineEntity>> getAllItems() {
        return itemsManagementService.fetchAllItems();
    }

    // POST request to add new items to inventory
    @PostMapping("/api/items-management/add")
    public ResponseEntity<List<ItemsManagementLineEntity>> addItem(@RequestBody List<ItemsManagementLineEntity> itemsManagementLineEntityList) {
        return itemsManagementService.addNewItem(itemsManagementLineEntityList);
    }

    // DELETE request to delete items from inventory by their Ids
    @DeleteMapping("/api/items-management/delete")
    public ResponseEntity<ItemsManagementDeleteModel> deleteItems(@RequestBody ItemsManagementDeleteModel itemIds) {
        return itemsManagementService.deleteItemsByIds(itemIds);
    }
}
