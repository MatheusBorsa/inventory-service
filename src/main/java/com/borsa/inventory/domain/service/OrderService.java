package com.borsa.inventory.domain.service;

import com.borsa.inventory.api.dto.order.OrderDTO;
import com.borsa.inventory.api.dto.order.OrderDTOMapper;
import com.borsa.inventory.domain.entity.Orders;
import com.borsa.inventory.domain.entity.Product;
import com.borsa.inventory.domain.repository.OrderRepository;
import com.borsa.inventory.domain.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderDTOMapper orderDTOMapper;

    @Autowired
    public OrderService(OrderRepository orderRepository, ProductRepository productRepository, OrderDTOMapper orderDTOMapper){
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.orderDTOMapper = orderDTOMapper;
    }

    public List<OrderDTO> listOrders(){
        return orderRepository.findAll()
        		.stream()
        		.map(orderDTOMapper::toDTO)
        		.collect(Collectors.toList());
    }

    public OrderDTO makeOrder(OrderDTO orderDTO){
        Optional<Product> optionalProduct = productRepository.findById(orderDTO.getProductId());

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            int orderedQuantity = orderDTO.getQuantity();
            int currentQuantity = product.getQuantity();

            if (currentQuantity >= orderedQuantity) {
                product.setQuantity(currentQuantity - orderedQuantity);
                productRepository.save(product);
                Orders orders = orderDTOMapper.toEntity(orderDTO);
                Orders newOrder = orderRepository.save(orders);
                return orderDTOMapper.toDTO(newOrder);
            } else {
                throw new IllegalArgumentException("Quantidade de " + product.getName() + " insuficiente");
            }
        } else {
            throw new IllegalArgumentException("Produto com " + orderDTO.getProductId() + " nao encontrado");
        }
    }

    public OrderDTO editOrder(OrderDTO orderDTO){
    	Orders orders = orderDTOMapper.toEntity(orderDTO);
        Orders newOrders = orderRepository.save(orders);
        return orderDTOMapper.toDTO(newOrders);
    }

    public Boolean cancelOrder(Integer id){
        if (orderRepository.existsById(id)){
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
