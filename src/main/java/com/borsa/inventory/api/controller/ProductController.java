package com.borsa.inventory.api.controller;

import com.borsa.inventory.api.dto.product.ProductDTO;
import com.borsa.inventory.domain.entity.Product;
import com.borsa.inventory.domain.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/produtos")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> productsList(){
    	List<ProductDTO> products = productService.listProducts();
        return ResponseEntity.status(200).body(products);
    }

    @PostMapping ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
    	ProductDTO newProduct = productService.createProduct(productDTO);
        return ResponseEntity.status(201).body(newProduct);
    }

    @PutMapping ResponseEntity<ProductDTO> editProduct(@RequestBody ProductDTO productDTO){
    	ProductDTO newProduct = productService.createProduct(productDTO);
        return ResponseEntity.status(200).body(newProduct);
    }

    @DeleteMapping("/{id}") ResponseEntity<?> deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
        return ResponseEntity.status(204).build();
    }
}
