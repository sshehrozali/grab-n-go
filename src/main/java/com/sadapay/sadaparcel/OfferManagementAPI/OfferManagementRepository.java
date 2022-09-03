package com.sadapay.sadaparcel.OfferManagementAPI;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferManagementRepository extends JpaRepository<OfferManagementEntity, String> {
}
