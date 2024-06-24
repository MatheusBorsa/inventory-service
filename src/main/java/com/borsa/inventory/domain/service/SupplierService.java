package com.borsa.inventory.domain.service;

import com.borsa.inventory.api.dto.supplier.SupplierDTO;
import com.borsa.inventory.api.dto.supplier.SupplierDTOMapper;
import com.borsa.inventory.domain.entity.Supplier;
import com.borsa.inventory.domain.repository.SupplierRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierService {

    private final SupplierRepository repository;
    private final SupplierDTOMapper supplierDTOMapper;

    @Autowired
    public SupplierService(SupplierRepository repository, SupplierDTOMapper supplierDTOMapper){
        this.repository = repository;
        this.supplierDTOMapper = supplierDTOMapper;
    }

    public List<SupplierDTO> listSuppliers(){
        return repository.findAll()
        		.stream()
        		.map(supplierDTOMapper::toDTO)
        		.collect(Collectors.toList());
    }

    public SupplierDTO contractSupplier(SupplierDTO supplierDTO){
        Supplier supplier = supplierDTOMapper.toEntity(supplierDTO);
        Supplier newSupplier = repository.save(supplier);
        return supplierDTOMapper.toDTO(newSupplier);
    }

    public Boolean fireSupplier(Integer id){
        repository.deleteById(id);
        return true;
    }
}
