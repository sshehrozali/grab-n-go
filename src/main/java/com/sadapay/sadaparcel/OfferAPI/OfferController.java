package com.sadapay.sadaparcel.OfferAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfferController {

    @GetMapping("/api/public/offer/test")
    public String testOfferAPI() {
        return "Test success Offer API 200";
    }
}
