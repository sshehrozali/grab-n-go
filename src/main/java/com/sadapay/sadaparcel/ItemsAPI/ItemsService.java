package com.sadapay.sadaparcel.ItemsAPI;

import com.sadapay.sadaparcel.ItemsManagementAPI.ItemsManagementLineEntity;
import com.sadapay.sadaparcel.ItemsManagementAPI.ItemsManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemsService {

    @Autowired
    private ItemsManagementRepository itemsManagementRepository;

    public ResponseEntity<List<ItemsLineModel>> getAllItems() {
        // List of type ItemsLineModel
        List<ItemsLineModel> itemsList = new ArrayList<>();

        // Fetch all items from Internal database - ItemsManagementLineEntity
        List<ItemsManagementLineEntity> lineEntities = itemsManagementRepository.findAll();

        // NOT PRODUCTION READY - SERVER LATENCY will be high for Fetching higher number of items
        // Iterate through List of type ItemsManagementLineEntity
        // Get each ItemsManagementLineEntity object and store each item's attribute
        // Create new ItemsItemModel object, assign values
        // Create ItemsLineModel object, assign values
        // Append ItemsLineModel object in List of type ItemsLineModel
        for (ItemsManagementLineEntity lineEntity : lineEntities) {
            final Integer id = lineEntity.getItem().getId();
            final String name = lineEntity.getItem().getName();
            final String description = lineEntity.getItem().getDescription();
            final Integer price = lineEntity.getItem().getPrice();
            final Integer quantity = lineEntity.getQuantity();

            ItemsItemModel itemsItemModel = new ItemsItemModel();
            itemsItemModel.setId(id);
            itemsItemModel.setName(name);
            itemsItemModel.setDescription(description);
            itemsItemModel.setPrice(price);

            ItemsLineModel itemsLineModel = new ItemsLineModel();
            itemsLineModel.setItem(itemsItemModel);
            itemsLineModel.setQuantity(quantity);

            itemsList.add(itemsLineModel);
        }

        // When done fetching and conversion, return with response 200
        return new ResponseEntity<List<ItemsLineModel>>(itemsList, HttpStatus.OK);
    }
}
