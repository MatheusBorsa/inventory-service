package com.borsa.inventory.api.dto.product;

import org.springframework.context.annotation.Configuration;

import com.borsa.inventory.domain.entity.Product;

@Configuration
public class ProductDTOMapper {
	public ProductDTO toDTO (Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setName(product.getName());
		productDTO.setPrice(product.getPrice());
		productDTO.setDescription(product.getDescription());
		productDTO.setQuantity(product.getQuantity());
		productDTO.setSupplierId(product.getSupplierId());
		return productDTO;
	}
	public Product toEntity (ProductDTO productDTO) {
		Product product = new Product();
		product.setName(productDTO.getName());
		product.setPrice(productDTO.getPrice());
		product.setDescription(productDTO.getDescription());
		product.setQuantity(productDTO.getQuantity());
		product.setSupplierId(productDTO.getSupplierId());
		return product;
	}
}