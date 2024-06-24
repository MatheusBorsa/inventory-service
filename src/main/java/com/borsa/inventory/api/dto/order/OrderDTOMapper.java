package com.borsa.inventory.api.dto.order;

import org.springframework.context.annotation.Configuration;

import com.borsa.inventory.domain.entity.Orders;

@Configuration
public class OrderDTOMapper {
	
	public OrderDTO toDTO(Orders orders) {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setId(orders.getId());
		orderDTO.setProductId(orders.getProductId());
		orderDTO.setQuantity(orders.getQuantity());
		orderDTO.setOrdererName(orders.getOrdererName());
		return orderDTO;
	}
	
	public Orders toEntity(OrderDTO orderDTO) {
		Orders orders = new Orders();
		orders.setId(orderDTO.getId());
		orders.setProductId(orderDTO.getProductId());
		orders.setQuantity(orderDTO.getQuantity());
		orders.setOrdererName(orderDTO.getOrdererName());
		return orders;
	}
}