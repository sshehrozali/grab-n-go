package com.sadapay.sadaparcel.ItemsManagementAPI;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsManagementRepository extends JpaRepository<ItemsManagementLineSchema, Integer> {
}
