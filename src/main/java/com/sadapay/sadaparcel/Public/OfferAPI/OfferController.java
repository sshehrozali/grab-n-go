package com.sadapay.sadaparcel.Public.OfferAPI;

import com.sadapay.sadaparcel.Internal.OfferManagementAPI.OfferManagementEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OfferController {

    @Autowired
    private OfferService offerService;

    @GetMapping("/api/public/offer/test")
    public String testOfferAPI() {
        return "Test success Offer API 200";
    }

    // GET request to fetch all available offers
    @GetMapping("/api/offers")
    public ResponseEntity<List<OfferManagementEntity>> getOffers() {
        return offerService.getAllOffers();
    }
}
