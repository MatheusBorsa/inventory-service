package com.borsa.inventory.api.dto.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private String name;
    private double price;
    private String description;
    private int quantity;
    private Integer supplierId;
}
