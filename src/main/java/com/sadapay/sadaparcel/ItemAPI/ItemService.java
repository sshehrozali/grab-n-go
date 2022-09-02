package com.sadapay.sadaparcel.ItemAPI;

import com.sadapay.sadaparcel.ItemManagementAPI.ItemManagementLineEntity;
import com.sadapay.sadaparcel.ItemManagementAPI.ItemsManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemsManagementRepository itemsManagementRepository;

    public ResponseEntity<List<ItemLineModel>> getAllItems() {
        // List of type ItemsLineModel
        List<ItemLineModel> itemsList = new ArrayList<>();

        // Fetch all items from Internal database - ItemsManagementLineEntity
        List<ItemManagementLineEntity> lineEntities = itemsManagementRepository.findAll();

        // NOT PRODUCTION READY - SERVER LATENCY will be high for Fetching higher number of items
        // Iterate through List of type ItemsManagementLineEntity
        // Get each ItemsManagementLineEntity object and store each item's attribute
        // Create new ItemsItemModel object, assign values
        // Create ItemsLineModel object, assign values
        // Append ItemsLineModel object in List of type ItemsLineModel
        for (ItemManagementLineEntity lineEntity : lineEntities) {
            final Integer id = lineEntity.getItem().getId();
            final String name = lineEntity.getItem().getName();
            final String description = lineEntity.getItem().getDescription();
            final Integer price = lineEntity.getItem().getPrice();
            final Integer quantity = lineEntity.getQuantity();

            ItemItemModel itemItemModel = new ItemItemModel();
            itemItemModel.setId(id);
            itemItemModel.setName(name);
            itemItemModel.setDescription(description);
            itemItemModel.setPrice(price);

            ItemLineModel itemLineModel = new ItemLineModel();
            itemLineModel.setItem(itemItemModel);
            itemLineModel.setQuantity(quantity);

            itemsList.add(itemLineModel);
        }

        // When done fetching and conversion, return with response 200
        return new ResponseEntity<List<ItemLineModel>>(itemsList, HttpStatus.OK);
    }
}