package com.sadapay.sadaparcel.customer.items;

import lombok.Data;

// Line Schema
@Data
public class Line {
    // One-to-one relation
    private Item item;
    private int quantity;
}
