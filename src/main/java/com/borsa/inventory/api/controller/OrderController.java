package com.borsa.inventory.api.controller;

import com.borsa.inventory.api.dto.order.OrderDTO;
import com.borsa.inventory.domain.entity.Orders;
import com.borsa.inventory.domain.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/pedidos")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> ordersList() {
    	List<OrderDTO> orders = orderService.listOrders();
        return ResponseEntity.status(200).body(orders);
    }

    @PostMapping
    ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
    	OrderDTO newOrder = orderService.makeOrder(orderDTO);
        return ResponseEntity.status(201).body(newOrder);
    }

    @PutMapping
    ResponseEntity<OrderDTO> editOrder(@RequestBody OrderDTO orderDTO) {
    	OrderDTO editedOrder = orderService.makeOrder(orderDTO);
        return ResponseEntity.status(200).body(editedOrder);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteOrder(@PathVariable Integer id) {
        orderService.cancelOrder(id);
        return ResponseEntity.status(204).build();
    }
}
