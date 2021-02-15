package com.inventory.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.entities.Catalog;
import com.inventory.entities.Supplier;
import com.inventory.repository.SupplierRepository;
import com.inventory.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {
	
	@Autowired
	private SupplierRepository supplierRepository;

	@Override
	public Supplier getSupplierById(int id) {
		return supplierRepository.findById(id).get();
	}
	
	@Override
	public Supplier insertSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

//	@Override
//	public List<String> getSKUNameList(int id, String subStr) {
//		
////		Supplier supplier = supplierRepository.findById(id).get();
////		List <Catalog> catalogList = supplier.getCatalogList();
////		
//		List<String>  skuNameList = new ArrayList<String>();
//		skuNameList = supplierRepository.getSKUName(id, subStr);
////		for(Catalog catalog : catalogList) {
////			skuNameList.add(catalog.getSkuName());
////		}
//		return skuNameList;
//	}
//	
	

}
