package com.sadapay.sadaparcel.Public.OrderAPI;

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
    private Integer id;     // primary key -> auto-generation
    private String offerId; // reference to offer
    private String itemId; // reference to item
    private Integer priceReduction;
    private Integer quantityThreshold;
}
