package com.grabngo.app.Internal.OfferManagementAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OfferManagementController {

    @Autowired
    private OfferManagementService offerManagementService;

    @GetMapping("/api/internal/offer/test")
    public String testOfferManagementAPI() {
        return "Test success 200 Offer Management API";
    }

    // GET request to get all offers
    @GetMapping("/api/get/offers")
    public ResponseEntity<List<OfferManagementEntity>> getOffers() {
        return offerManagementService.getAllOffers();
    }

    // POST request to upload all offers
    @PostMapping("/api/upload/offers")
    public ResponseEntity<List<OfferManagementEntity>> uploadOffers(@RequestBody List<OfferManagementEntity> offerManagementEntities) {
        return offerManagementService.uploadAllNewOffers(offerManagementEntities);
    }

    // DELETE request to delete all offers by their Ids
    @DeleteMapping("/api/delete/offers")
    public ResponseEntity<OfferManagementDeleteModel> deleteOffers(@RequestBody OfferManagementDeleteModel offerIdsToBeDeleted) {
        return offerManagementService.deleteAllOffersByIds(offerIdsToBeDeleted);
    }
}
