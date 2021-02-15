package com.inventory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.entities.Catalog;
import com.inventory.service.CatalogService;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {
	@Autowired
	private CatalogService catalogService;

	@PostMapping
	public int insertCatalog(@RequestBody Catalog catalog) {
		Catalog c = catalogService.saveCatalog(catalog);
		return c.getSkuCode();
	}
	
	@GetMapping("/{supplier_id}/{sub_str}")
	public List<String> getSKUNameList(@PathVariable int supplier_id, @PathVariable String sub_str) {
		//we can also search by using supplier name but supplier_id is unique so we are using supplier_id
		List<String> skuNameList = catalogService.getSKUNameList(supplier_id, sub_str);
		return skuNameList;
	}
	
//	@GetMapping("/rest/catalog1/{sku_code}")
//	public Catalog getCatalog(@PathVariable int sku_code) {
//		return catalogService.getCatalogById(sku_code);
//	}
}
