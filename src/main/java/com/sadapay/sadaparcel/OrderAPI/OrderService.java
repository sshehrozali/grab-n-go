package com.sadapay.sadaparcel.OrderAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Method that will return all Orders by their Ids
    public ResponseEntity<List<OrderEntity>> getOrdersById(List<String> values) {
        return new ResponseEntity<>(orderRepository.findAllById(values), HttpStatus.OK);
    }

    // Method that will save List of OrderEntity in database
    public ResponseEntity<List<OrderEntity>> placeNewOrders(List<OrderEntity> orderEntities) {
        return new ResponseEntity<>(orderRepository.saveAll(orderEntities), HttpStatus.OK);     // return 200 OK
    }
}
