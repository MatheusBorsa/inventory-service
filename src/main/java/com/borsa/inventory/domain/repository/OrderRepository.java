package com.borsa.inventory.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.borsa.inventory.domain.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {
}
