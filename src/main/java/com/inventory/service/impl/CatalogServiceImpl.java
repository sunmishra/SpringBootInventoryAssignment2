package com.inventory.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.entities.Catalog;
import com.inventory.repository.CatalogRepository;
import com.inventory.service.CatalogService;

@Service
public class CatalogServiceImpl implements CatalogService {
	
	@Autowired
	private CatalogRepository catalogRepository;
	
	@Override
	public Catalog getCatalogById(int id) {
		return catalogRepository.findById(id).get();
	}
	
	@Override
	public Catalog saveCatalog(Catalog catalog) {
		return catalogRepository.save(catalog);
	}
	
	@Override
	public List<String> getSKUNameList(int id, String subStr) {
		
//		Supplier supplier = supplierRepository.findById(id).get();
//		List <Catalog> catalogList = supplier.getCatalogList();
//		
		List<String>  skuNameList = new ArrayList<String>();
		skuNameList = catalogRepository.getSKUName(id, subStr);
//		for(Catalog catalog : catalogList) {
//			skuNameList.add(catalog.getSkuName());
//		}
		return skuNameList;
	}
	

	
}
