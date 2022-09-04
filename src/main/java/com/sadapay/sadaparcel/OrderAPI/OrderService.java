package com.sadapay.sadaparcel.OrderAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Method that will return all Orders by matching their Ids from query parameter
    public ResponseEntity<List<Optional<OrderEntity>>> getOrdersByIds(List<String> values) {
        List<Optional<OrderEntity>> orders = new ArrayList<>();
        if (orderRepository.findAll().isEmpty()) {
            // If no Orders were placed yet, Throw Error!
            System.out.println("No Order Found yet!");
            return new ResponseEntity<>(orders, HttpStatus.NOT_FOUND);
        } else {
            values.forEach(order_id -> {
                // If no Order found by given Id, Throw Error!
                if (orderRepository.findById(order_id).isEmpty()) {
                    System.out.println("No Order found by Id: " + order_id);
                } else {
                    // Add Order in List
                    orders.add(orderRepository.findById(order_id));
                }
            });
        }
        return new ResponseEntity<>(orders, HttpStatus.OK); // return all orders with HTTP Status 200 OK
    }

    // Method that will save List of OrderEntity in database
    public ResponseEntity<List<OrderEntity>> placeNewOrders(List<OrderEntity> orderEntities) {
        return new ResponseEntity<>(orderRepository.saveAll(orderEntities), HttpStatus.OK);     // return 200 OK
    }
}
