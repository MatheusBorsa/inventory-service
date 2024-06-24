package com.borsa.inventory.api.dto.order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
    private Integer id;
    private Integer productId;
    private Integer quantity;
    private String ordererName;
}
