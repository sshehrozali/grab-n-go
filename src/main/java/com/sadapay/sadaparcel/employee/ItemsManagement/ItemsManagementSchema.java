package com.sadapay.sadaparcel.employee.ItemsManagement;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

// items-management-item schema
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemsManagementSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private Integer price;
    @NotNull
    private Integer cost;
}
