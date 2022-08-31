package com.sadapay.sadaparcel.customer.items;

import lombok.Data;

// Item Schema
@Data
public class Item {
    private String id;
    private String name;
    private String description;
    private int price;
}
