package com.grabngo.app.Internal.ItemManagementAPI;

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
public class ItemManagementLineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // Automatically generates id for each record in table
    private Integer id;     // primary key
    @OneToOne(cascade = CascadeType.ALL)
    private ItemManagementItemEntity item;    // Stores itemId
    @NotNull
    private int quantity;   // Quantity of that item
}
