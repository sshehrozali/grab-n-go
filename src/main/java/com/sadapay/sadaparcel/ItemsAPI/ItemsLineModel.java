package com.sadapay.sadaparcel.ItemsAPI;

import lombok.Data;

// Line schema for public user (this will be returned as response body)
@Data
public class ItemsLineModel {
    private ItemsItemModel item;
    private Integer quantity;
}
