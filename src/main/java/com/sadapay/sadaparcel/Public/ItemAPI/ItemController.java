package com.sadapay.sadaparcel.ItemAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/api/public/test")
    public String testPublicAPI() {
        return "Test success Public API 200";
    }

    @GetMapping("/api/items")
    public ResponseEntity<List<ItemLineModel>> getItems() {
        return itemService.getAllItems();
    }
}
