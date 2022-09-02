package com.sadapay.sadaparcel.OrderAPI;

public class OrderOfferEntity {
    private Integer id;     // primary key
    private Integer itemId; // OrderItemEntity -> establish relationship here
    private Integer priceReduction;
    private Integer quantityThreshold;
}
