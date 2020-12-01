package com.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
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
	@Autowired
	private SupplierService supplierService;
	
	@MockBean
	private CatalogRepository catalogRepository;
	
	@MockBean
	private SupplierRepository supplierRepository;
	
	Supplier supplier = null;
	Catalog catalog = null; 
	
	@Before
	void setUp() {
		MockitoAnnotations.initMocks(this);
		catalog = new Catalog();
		catalog.setbName("Bajaj");
		catalog.setbDesc("Eletrical gadgets");
		catalog.setSkuCode(101);
		catalog.setSkuName("Mixer");
		supplier = new Supplier();
		supplier.setSupplierId(1);
		supplier.setSupplierName("Shubham");
		catalog.setSupplier(supplier);
		supplier.setCatalog(catalog);
	}
	
	@Test
	public void getCatalogByIdTest() {
		setUp();
		when(catalogRepository.findById(201)).thenReturn(Optional.of(catalog));
		assertEquals(catalog,catalogSevice.getCatalogById(201));
	}
	
	@Test
	public void getSKUNameTest() {
		setUp();
		when(supplierRepository.findById(1)).thenReturn(Optional.of(supplier));
		assertEquals("Mixer",supplierService.getSupplierById(1).getCatalog().getSkuName());
	}

	
	@Test
	public void insetCatalogTest() {
		setUp();
		when(catalogRepository.save(catalog)).thenReturn(catalog);
		assertEquals(catalog, catalogSevice.saveCatalog(catalog));
	}
	
	
	@Test
	public void insertSupplierTest() {
		setUp();
		when(supplierRepository.save(supplier)).thenReturn(supplier);
		assertEquals(supplier, supplierService.insertSupplier(supplier));
	}

}
