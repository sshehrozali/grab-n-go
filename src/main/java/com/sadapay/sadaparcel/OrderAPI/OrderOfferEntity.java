package com.sadapay.sadaparcel.OrderAPI;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Entity
@Table(name = "orderOffers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderOfferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;     // primary key
    private String itemId; // itemId reference to item on which offer is valid
    private Integer priceReduction;
    private Integer quantityThreshold;
}
