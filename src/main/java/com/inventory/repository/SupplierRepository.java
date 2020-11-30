package com.inventory.repository;

import org.springframework.data.repository.CrudRepository;

import com.inventory.entities.Supplier;

public interface SupplierRepository extends CrudRepository<Supplier, Integer>{

}
