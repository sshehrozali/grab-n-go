package com.sadapay.sadaparcel.OfferAPI;

import com.sadapay.sadaparcel.OfferManagementAPI.OfferManagementEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfferController {

    @Autowired
    private OfferService offerService;

    @GetMapping("/api/public/offer/test")
    public String testOfferAPI() {
        return "Test success Offer API 200";
    }

    @GetMapping("/api/offers")
    public ResponseEntity<List<OfferManagementEntity>> getOffers() {
        return
    }
}
