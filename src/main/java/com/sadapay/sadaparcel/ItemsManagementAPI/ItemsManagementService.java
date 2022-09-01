package com.sadapay.sadaparcel.ItemsManagementAPI;

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

    // Method to save new items in inventory
    public ResponseEntity<List<ItemsManagementLineSchema>> addNewItem(List<ItemsManagementLineSchema> itemsManagementLineSchemaList) {
        return new ResponseEntity<List<ItemsManagementLineSchema>>(itemsManagementRepository.saveAll(itemsManagementLineSchemaList), HttpStatus.OK);
    }

    // Method to delete items from inventory by their Ids
    public ResponseEntity<ItemsDeleteModel> deleteItemsByIds(ItemsDeleteModel itemIds) {
        itemsManagementRepository.deleteAllById(itemIds.getItemIds());  // Delete all items by their Ids
        return new ResponseEntity<ItemsDeleteModel>(itemIds, HttpStatus.OK); // return list of deleted item Ids
    }
}
