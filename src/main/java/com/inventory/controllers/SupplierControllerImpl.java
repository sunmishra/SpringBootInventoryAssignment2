package com.inventory.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.entities.Catalog;
import com.inventory.entities.Supplier;
import com.inventory.service.SupplierService;

@RestController
public class SupplierControllerImpl {
	@Autowired
	private SupplierService supplierService;

	@GetMapping("/rest/supplier/{supplier_id}")
	public String getSKUName(@PathVariable int supplier_id) {
		Supplier supplier = supplierService.getSupplierById(supplier_id);
		return supplier.getCatalog().getSkuName();
	}

//  To get catalog obj using FK
//	@GetMapping("/supplier1/{supplier_id}")
//	public Catalog getCatalog(@PathVariable int supplier_id) {
//		Supplier supplier = supplierService.getSupplierById(supplier_id);
//		return supplier.getCatalog();
//	}

	@PostMapping("/rest/supplier")
	public int insertSupplier(@RequestBody Supplier supplier) {
		Supplier s = supplierService.insertSupplier(supplier);
		return s.getSupplierId();
	}

}
