package com.sadapay.sadaparcel.Public.OrderAPI;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, String> {
}
