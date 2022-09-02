package com.sadapay.sadaparcel.OrderAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    // POST request to place new Orders
    @PostMapping("/api/order/place")
    public ResponseEntity<List<OrderEntity>> placeOrder(@RequestBody List<OrderEntity> orderEntities) {
        return orderService.placeNewOrder(orderEntities);
    }
}
