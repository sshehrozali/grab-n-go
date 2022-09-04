package com.sadapay.sadaparcel.ItemManagementAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemManagementService {
    @Autowired
    private ItemManagementItemRepository itemManagementItemRepository;
    @Autowired
    private ItemManagementLineRepository itemManagementLineRepository;


    // Method to fetch all items available in inventory
    public ResponseEntity<List<ItemManagementLineEntity>> fetchAllItems() {
        if (itemManagementLineRepository.findAll().isEmpty()) {
            // If no items are available in inventory, return empty with response code NOT_FOUND
            return new ResponseEntity<List<ItemManagementLineEntity>>(itemManagementLineRepository.findAll(), HttpStatus.NOT_FOUND);
        } else {
            // Else return List of items with response code 200 OK
            return new ResponseEntity<List<ItemManagementLineEntity>>(itemManagementLineRepository.findAll(), HttpStatus.OK);
        }
    }

    // Method to save new items in inventory
    public ResponseEntity<List<ItemManagementLineEntity>> addNewItems(List<ItemManagementLineEntity> itemManagementLineEntityList) {

        // Query repository
        // If TRUE -> item already exists -> throw Error
        // If FALSE -> item doesn't exists -> Save in database

        return new ResponseEntity<List<ItemManagementLineEntity>>(itemManagementLineRepository.saveAll(itemManagementLineEntityList), HttpStatus.OK);
    }

    // Method to delete items from inventory by their Ids
    public ResponseEntity<ItemManagementDeleteModel> deleteItemsByIds(ItemManagementDeleteModel itemIds) {
        itemManagementLineRepository.deleteAllById(itemIds.getItemIds());  // Delete all items by their Ids
        return new ResponseEntity<ItemManagementDeleteModel>(itemIds, HttpStatus.OK); // return list of deleted item Ids
    }
}
