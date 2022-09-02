package com.sadapay.sadaparcel.OrderAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/api/public/orders/test")
    public String testOrdersAPI() {
        return "Test Success Orders API 200";
    }

    @PostMapping("/api/order/place")
    public List<OrderEntity> placeOrder(@RequestBody List<OrderEntity> orderEntities) {
        return
    }
}
