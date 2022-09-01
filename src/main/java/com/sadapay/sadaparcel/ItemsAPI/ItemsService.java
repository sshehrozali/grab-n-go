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
        List<ItemsLineModel> itemsList = new ArrayList<>();

        List<ItemsManagementLineEntity> lineEntities = itemsManagementRepository.findAll();
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

        return new ResponseEntity<List<ItemsLineModel>>(itemsList, HttpStatus.OK);
    }
}
