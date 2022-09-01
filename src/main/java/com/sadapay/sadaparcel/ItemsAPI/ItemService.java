package com.sadapay.sadaparcel.ItemsAPI;

import com.sadapay.sadaparcel.ItemsManagementAPI.ItemsManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ItemsManagementRepository itemsManagementRepository;
}
