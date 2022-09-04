package com.sadapay.sadaparcel.ItemManagementAPI;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemManagementItemRepository extends JpaRepository<ItemManagementItemEntity, String> {
}
