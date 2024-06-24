package com.borsa.inventory.api.dto.supplier;

import org.springframework.context.annotation.Configuration;

import com.borsa.inventory.domain.entity.Supplier;

@Configuration
public class SupplierDTOMapper {
	
	public SupplierDTO toDTO(Supplier supplier) {
		SupplierDTO supplierDTO = new SupplierDTO();
		supplierDTO.setName(supplier.getName());
		supplierDTO.setContactNumber(supplier.getContactNumber());
		supplierDTO.setSupplierCnpj(supplier.getSupplierCnpj());
		return supplierDTO;	
	}	
	
	public Supplier toEntity(SupplierDTO supplierDTO) {
		Supplier supplier = new Supplier();
		supplier.setName(supplierDTO.getName());
		supplier.setContactNumber(supplierDTO.getContactNumber());
		supplier.setSupplierCnpj(supplierDTO.getSupplierCnpj());
		return supplier;
	}
}
