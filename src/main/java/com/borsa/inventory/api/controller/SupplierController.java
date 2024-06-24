package com.borsa.inventory.api.controller;

import com.borsa.inventory.api.dto.supplier.SupplierDTO;
import com.borsa.inventory.domain.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/fornecedores")
public class SupplierController {

    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public ResponseEntity<List<SupplierDTO>> suppliersList() {
    	List<SupplierDTO> suppliers = supplierService.listSuppliers();
        return ResponseEntity.status(200).body(suppliers);
    }

    @PostMapping
    ResponseEntity<SupplierDTO> contractSupplier(@RequestBody SupplierDTO supplierDTO) {
    	SupplierDTO newSupplier = supplierService.contractSupplier(supplierDTO);
        return ResponseEntity.status(201).body(newSupplier);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> fireSupplier(@PathVariable Integer id) {
        supplierService.fireSupplier(id);
        return ResponseEntity.status(204).build();
    }
}
