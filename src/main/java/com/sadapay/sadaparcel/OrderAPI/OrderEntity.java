package com.sadapay.sadaparcel.OrderAPI;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    @OneToMany
    private List<OrderItemEntity> orderItems; // Each Order can have multiple Order Items (One-to-Many)
    private List<OrderOfferEntity> orderOffers; // OrderOfferEntity -> establish relationship here
}
