package com.inventory.service;

import java.util.List;

import com.inventory.entities.Catalog;

public interface CatalogService {

	Catalog getCatalogById(int id);

	Catalog saveCatalog(Catalog catalog);

	List<String> getSKUNameList(int supplier_id, String sub_str);

}