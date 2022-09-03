package com.sadapay.sadaparcel.OfferManagementAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfferManagementController {

    @GetMapping("/api/internal/offer/test")
    public String testOfferManagementAPI() {
        return "Test success 200 Offer Management API";
    }
}
