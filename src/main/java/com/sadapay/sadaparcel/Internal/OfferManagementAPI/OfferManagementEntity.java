package com.sadapay.sadaparcel.OfferManagementAPI;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.sql.In;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "offers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OfferManagementEntity {
    @Id
    private String id;
    private String name;
    private String itemId;
    private Integer priceReduction;
    private String description;
    private Integer quantityThreshold;
}
