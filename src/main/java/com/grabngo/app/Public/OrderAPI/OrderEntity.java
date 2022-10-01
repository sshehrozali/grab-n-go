package com.grabngo.app.Public.OrderAPI;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderEntity {
    @Id
    private String id;  // primary key, must be unique, provided by user
    @OneToMany(cascade = CascadeType.ALL)      // Means when Order is created -> Order Item will also be created
    private List<OrderItemEntity> orderItems; // Each Order can have multiple Order Items (One-to-Many)
    @OneToMany(cascade = CascadeType.ALL)       // Means when Order is created -> Order Offer will also be created
    private List<OrderOfferEntity> orderOffers; // Each Order can have multiple number of offers because of multiple number of Order Items (One-to-Many)
}
