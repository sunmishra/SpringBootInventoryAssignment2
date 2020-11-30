package com.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.entities.Supplier;
import com.inventory.repository.SupplierRepository;

@Service
public class SupplierService {
	
	@Autowired
	private SupplierRepository supplierRepository;

	public Supplier getSupplierById(int id) {
		return supplierRepository.findById(id).get();
	}
	
	public Supplier insertSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}
	

}
