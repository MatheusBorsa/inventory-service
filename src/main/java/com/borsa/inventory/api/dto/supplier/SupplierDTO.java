package com.borsa.inventory.api.dto.supplier;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplierDTO {
	private String name;
    private String supplierCnpj;
    private String contactNumber;
}
