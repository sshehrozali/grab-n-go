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
public class ItemService {

    @Autowired
    private ItemsManagementRepository itemsManagementRepository;

    public ResponseEntity<List<LineModel>> getAllItems() {
        List<LineModel> itemsList = new ArrayList<>();

        List<ItemsManagementLineEntity> lineEntities = itemsManagementRepository.findAll();
        for (ItemsManagementLineEntity lineEntity : lineEntities) {
            final Integer id = lineEntity.getItem().getId();
            final String name = lineEntity.getItem().getName();
            final String description = lineEntity.getItem().getDescription();
            final Integer price = lineEntity.getItem().getPrice();
            final Integer quantity = lineEntity.getQuantity();

            ItemModel itemModel = new ItemModel();
            itemModel.setId(id);
            itemModel.setName(name);
            itemModel.setDescription(description);
            itemModel.setPrice(price);

            LineModel lineModel = new LineModel();
            lineModel.setItem(itemModel);
            lineModel.setQuantity(quantity);

            itemsList.add(lineModel);
        }

        return new ResponseEntity<List<LineModel>>(itemsList, HttpStatus.OK);
    }
}
