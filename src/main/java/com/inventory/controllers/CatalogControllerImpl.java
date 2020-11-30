package com.inventory.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.entities.Catalog;
import com.inventory.service.CatalogService;

@RestController
public class CatalogControllerImpl {
	@Autowired
	private CatalogService catalogService;

	@PostMapping("/rest/catalog")
	public int insertCatalog(@RequestBody Catalog catalog) {
		Catalog c = catalogService.saveCatalog(catalog);
		return c.getSkuCode();
	}
	
//	@GetMapping("/rest/catalog1/{sku_code}")
//	public Catalog getCatalog(@PathVariable int sku_code) {
//		return catalogService.getCatalogById(sku_code);
//	}
}
