package com.sadapay.sadaparcel.employee.ItemsManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsManagementService {
    @Autowired
    private ItemsManagementRepository itemsManagementRepository;


    // Method to fetch all items available in inventory
    public ResponseEntity<List<ItemsManagementLineSchema>> fetchAllItems() {
        if (itemsManagementRepository.findAll().isEmpty()) {
            // If no items are available in inventory, return empty with response code NOT_FOUND
            return new ResponseEntity<List<ItemsManagementLineSchema>>(itemsManagementRepository.findAll(), HttpStatus.NOT_FOUND);
        } else {
            // Else return List of items with response code 200 OK
            return new ResponseEntity<List<ItemsManagementLineSchema>>(itemsManagementRepository.findAll(), HttpStatus.OK);
        }
    }
}
