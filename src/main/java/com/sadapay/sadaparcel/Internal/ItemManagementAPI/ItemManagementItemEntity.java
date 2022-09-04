package com.sadapay.sadaparcel.ItemManagementAPI;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

// items-management-item schema
@Entity
@Table(name = "items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemManagementItemEntity {
    @Id
    private String id;  // primary key - should be unique -> provided by user, no auto-generation
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private Integer price;
    @NotNull
    private Integer cost;
}
