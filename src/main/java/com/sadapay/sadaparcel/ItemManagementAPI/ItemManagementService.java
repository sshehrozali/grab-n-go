package com.sadapay.sadaparcel.ItemManagementAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    // Method to save new items to inventory that already don't exist
    public ResponseEntity<List<ItemManagementLineEntity>> addNewItems(List<ItemManagementLineEntity> itemManagementLineEntityList) {
        itemManagementLineEntityList.forEach(itemManagementLineEntity -> {
            // Query "items" table by itemId
            Optional<ItemManagementItemEntity> item = itemManagementItemRepository.findById(itemManagementLineEntity.getItem().getId());
            if (item.isEmpty()) {
                // If item is already not stored -> Save item in database
                itemManagementLineRepository.save(itemManagementLineEntity);
            } else {
                // If item is already stored -> Throw Error!
                System.out.println("Item Already exists!");
            }
        });
        return new ResponseEntity<>(itemManagementLineEntityList, HttpStatus.OK);   // After saving all items, return 200 OK
}

    // Method to delete items from inventory by their Ids
    public ResponseEntity<ItemManagementDeleteModel> deleteItemsByIds(ItemManagementDeleteModel itemIds) {
        itemManagementLineRepository.deleteAllById(itemIds.getItemIds());  // Delete all items by their Ids
        return new ResponseEntity<ItemManagementDeleteModel>(itemIds, HttpStatus.OK); // return list of deleted item Ids
    }
}
