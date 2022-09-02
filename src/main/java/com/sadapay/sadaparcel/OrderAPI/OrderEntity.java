package com.sadapay.sadaparcel.OrderAPI;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderEntity {
    @Id
    private String id;  // primary key
    private List<OrderItemEntity> orderItems; // OrderItemEntity -> establish relationship here
    private List<OrderOfferEntity> orderOffers; // OrderOfferEntity -> establish relationship here
}
