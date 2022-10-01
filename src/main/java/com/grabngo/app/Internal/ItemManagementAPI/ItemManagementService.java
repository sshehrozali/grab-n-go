package com.grabngo.app.Internal.ItemManagementAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
            // If no items available in database -> Display Message! -> HTTP Status NOT FOUND
            System.out.println("No Items in Inventory!");
            return new ResponseEntity<>(itemManagementLineRepository.findAll(), HttpStatus.NOT_FOUND);
        } else {
            // Else return all items with HTTP status 200
            return new ResponseEntity<>(itemManagementLineRepository.findAll(), HttpStatus.OK);
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

    // Method to delete items from inventory by their Ids if they are present
    @Transactional  // indicate Spring that transaction is happening
    public ResponseEntity<ItemManagementDeleteModel> deleteItemsByIds(ItemManagementDeleteModel itemIds) {
        List<String> ids = itemIds.getItemIds();
        ids.forEach(id -> {
            // Query "items" table by itemId
            Optional<ItemManagementItemEntity> item = itemManagementItemRepository.findById(id);
            if (item.isPresent()) {
                // If item is present, delete from both tables separately, not optimal approach
                // Delete from "lines" table -> by ITEM_ID
                itemManagementLineRepository.deleteItemByItem_id(id);
                // Delete from "items" table -> by ID
                itemManagementItemRepository.deleteById(id);
            } else {
                // If item not present -> Throw Error!
                System.out.println("Item not present by the given Id!");
            }
        });
        return new ResponseEntity<>(itemIds, HttpStatus.OK);    // After deleting, return 200 OK
    }
}
