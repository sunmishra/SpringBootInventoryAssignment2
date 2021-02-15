package com.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.inventory.entities.Supplier;

public interface SupplierRepository extends CrudRepository<Supplier, Integer>{

	@Query(value = "SELECT c.sku_name FROM catalog c where c.supplier = :id and c.sku_name LIKE %:subStr%", nativeQuery = true)
	List<String> getSKUName(int id, @Param("subStr")String subStr);
}
