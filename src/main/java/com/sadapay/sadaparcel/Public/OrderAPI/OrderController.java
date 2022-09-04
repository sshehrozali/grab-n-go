package com.sadapay.sadaparcel.OrderAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/api/public/orders/test")
    public String testOrdersAPI() {
        return "Test Success Orders API 200";
    }

    // GET request to get all Orders by their Ids
    @GetMapping("/api/orders")
    public ResponseEntity<List<Optional<OrderEntity>>> getOrders(@RequestParam List<String> values) {
        return orderService.getOrdersByIds(values);
    }

    // POST request to place new Orders
    @PostMapping("/api/orders/place")
    public ResponseEntity<List<OrderEntity>> placeOrder(@RequestBody List<OrderEntity> orderEntities) {
        return orderService.placeNewOrders(orderEntities);
    }
}
