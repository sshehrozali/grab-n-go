package com.sadapay.sadaparcel.ItemsManagementAPI;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

// items-management-line schema
@Entity
@Table(name = "lines")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemsManagementLineEntity {
    @Id
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL)
    private ItemsManagementItemEntity item;    // Item
    @NotNull
    private int quantity;   // Quantity of Item
}