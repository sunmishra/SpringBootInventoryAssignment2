package com.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.entities.Catalog;
import com.inventory.repository.CatalogRepository;

@Service
public class CatalogService {
	
	@Autowired
	private CatalogRepository catalogRepository;
	
	public Catalog getCatalogById(int id) {
		return catalogRepository.findById(id).get();
	}
	
	public Catalog saveCatalog(Catalog catalog) {
		return catalogRepository.save(catalog);
	}
	
}
