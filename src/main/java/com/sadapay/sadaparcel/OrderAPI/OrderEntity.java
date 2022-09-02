package com.sadapay.sadaparcel.OrderAPI;

import java.util.List;

public class OrderEntity {
    private String id;  // primary key
    private List<OrderItemEntity> orderItems; // OrderItemEntity -> establish relationship here
    private List<OrderOfferEntity> orderOffers; // OrderOfferEntity -> establish relationship here
}
