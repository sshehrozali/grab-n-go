package com.sadapay.sadaparcel.OrderAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @GetMapping("/api/public/orders/test")
    public String testOrdersAPI() {
        return "Test Success Orders API 200";
    }
}
