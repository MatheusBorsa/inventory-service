package com.borsa.inventory.domain.service;

import com.borsa.inventory.api.dto.product.ProductDTO;
import com.borsa.inventory.api.dto.product.ProductDTOMapper;
import com.borsa.inventory.domain.entity.Product;
import com.borsa.inventory.domain.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
	
    private final ProductRepository repository;
    private final ProductDTOMapper productDTOMapper;

    @Autowired
    public ProductService(ProductRepository repository, ProductDTOMapper productDTOMapper){
        this.repository = repository;
        this.productDTOMapper = productDTOMapper;
    }

    public List<ProductDTO> listProducts(){
        return repository.findAll()
        		.stream()
        		.map(productDTOMapper::toDTO)
        		.collect(Collectors.toList());
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
    	Product product = productDTOMapper.toEntity(productDTO);
        Product newProduct = repository.save(product);
        return productDTOMapper.toDTO(newProduct);
    }

    public ProductDTO editProduct(ProductDTO productDTO){
    	Product product = productDTOMapper.toEntity(productDTO);
        Product newProduct = repository.save(product);
        return productDTOMapper.toDTO(newProduct);
    }

    public Boolean deleteProduct(Integer id){
        repository.deleteById(id);
        return true;
    }
}
