package com.sadapay.sadaparcel.OfferManagementAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OfferManagementController {

    @Autowired
    private OfferManagementService offerManagementService;

    @GetMapping("/api/internal/offer/test")
    public String testOfferManagementAPI() {
        return "Test success 200 Offer Management API";
    }

    // POST request to upload all offers
    @PostMapping("/api/upload/offers")
    public ResponseEntity<List<OfferManagementEntity>> uploadOffers(@RequestBody List<OfferManagementEntity> offerManagementEntities) {
        return offerManagementService.uploadAllNewOffers(offerManagementEntities);
    }
}
