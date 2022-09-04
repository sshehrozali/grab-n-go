package com.sadapay.sadaparcel.ItemManagementAPI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemManagementLineRepository extends JpaRepository<ItemManagementLineEntity, Integer> {
}
