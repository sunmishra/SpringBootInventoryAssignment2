package com.inventory.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.entities.Catalog;
import com.inventory.entities.Supplier;
import com.inventory.service.SupplierService;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
	@Autowired
	private SupplierService supplierService;

	

//  To get catalog obj using FK
//	@GetMapping("/supplier1/{supplier_id}")
//	public Catalog getCatalog(@PathVariable int supplier_id) {
//		Supplier supplier = supplierService.getSupplierById(supplier_id);
//		return supplier.getCatalog();
//	}

	@PostMapping
	public int insertSupplier(@RequestBody Supplier supplier) {
		Supplier s = supplierService.insertSupplier(supplier);
		return s.getSupplierId();
	}

}
