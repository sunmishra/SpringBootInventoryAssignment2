package com.inventory.service;

import java.util.List;

import com.inventory.entities.Supplier;

public interface SupplierService {

	Supplier getSupplierById(int id);

	Supplier insertSupplier(Supplier supplier);
	
	//List<String> getSKUNameList(int id, String subStr);

}