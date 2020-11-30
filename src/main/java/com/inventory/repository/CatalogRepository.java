package com.inventory.repository;

import org.springframework.data.repository.CrudRepository;

import com.inventory.entities.Catalog;

public interface CatalogRepository extends CrudRepository<Catalog, Integer>{

}
