package com.sadapay.sadaparcel.ItemManagementAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemManagementController {

    @Autowired
    private ItemManagementService itemManagementService;

    @GetMapping("/api/internal/test")
    public String testAPI() {
        return "Test success 200";
    }

    // GET request to fetch all items
    @GetMapping("/api/items-management/fetch")
    public ResponseEntity<List<ItemManagementLineEntity>> getAllItems() {
        return itemManagementService.fetchAllItems();
    }

    // POST request to add new items to inventory
    @PostMapping("/api/items-management/add")
    public ResponseEntity<List<ItemManagementLineEntity>> addItem(@RequestBody List<ItemManagementLineEntity> itemManagementLineEntityList) {
        return itemManagementService.addNewItems(itemManagementLineEntityList);
    }

    // DELETE request to delete items from inventory by their Ids
    @DeleteMapping("/api/items-management/delete")
    public ResponseEntity<ItemManagementDeleteModel> deleteItems(@RequestBody ItemManagementDeleteModel itemIds) {
        return itemManagementService.deleteItemsByIds(itemIds);
    }
}
