package com.sadapay.sadaparcel.ItemsAPI;

import lombok.Data;

// Item schema for public user
@Data
public class ItemsItemModel {
    private Integer id;
    private String name;
    private String description;
    private Integer price;
}
