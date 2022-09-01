package com.sadapay.sadaparcel.employee.ItemsManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/api/items-management")
    public ResponseEntity<List<ItemsManagementLineSchema>> getAllItems() {
        return itemsManagementService.fetchAllItems();
    }
}
