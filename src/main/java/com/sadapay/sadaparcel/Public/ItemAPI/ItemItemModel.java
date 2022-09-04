package com.sadapay.sadaparcel.ItemAPI;

import lombok.Data;

// Item schema for public user
@Data
public class ItemItemModel {
    private String id;
    private String name;
    private String description;
    private Integer price;
}
