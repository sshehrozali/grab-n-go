package com.sadapay.sadaparcel.employee.ItemsManagement;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

// items-management-line schema
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemsManagementLineSchema {
    @Id
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    private ItemsManagementSchema item;    // Item
    @NotNull
    private int quantity;
}
