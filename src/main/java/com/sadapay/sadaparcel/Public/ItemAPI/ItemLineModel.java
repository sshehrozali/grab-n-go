package com.sadapay.sadaparcel.Public.ItemAPI;

import lombok.Data;

// Line schema for public user (this will be returned as response body)
@Data
public class ItemLineModel {
    private ItemItemModel item;
    private Integer quantity;
}
