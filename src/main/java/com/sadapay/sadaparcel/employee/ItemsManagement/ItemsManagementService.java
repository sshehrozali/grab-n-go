package com.sadapay.sadaparcel.employee.ItemsManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsManagementService {
    @Autowired
    private ItemsManagementRepository itemsManagementRepository;


    public List<ItemsManagementLineSchema> fetchAllItems() {
        return itemsManagementRepository.findAll();
    }
}
