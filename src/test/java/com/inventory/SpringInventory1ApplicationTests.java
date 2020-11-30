package com.inventory;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.inventory.entities.Catalog;
import com.inventory.entities.Supplier;
import com.inventory.repository.CatalogRepository;
import com.inventory.repository.SupplierRepository;
import com.inventory.service.CatalogService;
import com.inventory.service.SupplierService;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringInventory1ApplicationTests {

	@Autowired
	private CatalogService catalogSevice;
	@InjectMocks
	private SupplierService supplierService;
	
	@MockBean
	private CatalogRepository catalogRepository;
	
	@Mock
	private SupplierRepository supplierRepository;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getCatalogByIdTest() {
		Catalog catalog = new Catalog(201,"Kitchen Products", "Daily Products", "bajaj", "bajaj Eletronics", new Supplier(1,"Shubham"));
		when(catalogRepository.findById(201)).thenReturn(Optional.of(catalog));
		assertEquals(catalog,catalogSevice.getCatalogById(201));
	}
	
//	@Test
//	public void getSKUNameTest() {
//		Catalog catalog = new Catalog(201,"Kitchen Products", "Daily Products", "bajaj", "bajaj Eletronics", new Supplier(6,"Shubham"));
//		Supplier supplier = new Supplier(1,"Shubham");
//		supplier.setCatalog(catalog);		
//		when(supplierRepository.findById(1).get()).thenReturn(supplier);
//		Supplier s = supplierRepository.findById(1).get();
//		when(supplierRepository.findById(1)).thenReturn(Optional.of(supplier));
//		Supplier s1 = supplierService.getSupplierById(1);
//		assertNotNull(s);
//		String name = s.getCatalog().getSkuName();
//		assertEquals("Mixer", s.getCatalog().getSkuName());
//	}

	
	@Test
	public void insetCatalogTest() {
		Catalog catalog = new Catalog(201,"Kitchen Products", "Daily Products", "bajaj", "bajaj Eletronics", new Supplier(6,"Shubham"));
		when(catalogRepository.save(catalog)).thenReturn(catalog);
		assertEquals(catalog, catalogSevice.saveCatalog(catalog));
	}
	
	
	@Test
	public void insertSupplierTest() {
		Supplier supplier = new Supplier(20, "Shubhanjali");
		when(supplierRepository.save(supplier)).thenReturn(supplier);
		assertEquals(supplier, supplierService.insertSupplier(supplier));
	}

}