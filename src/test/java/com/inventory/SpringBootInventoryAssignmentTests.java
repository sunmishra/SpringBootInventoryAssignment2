package com.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
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
class SpringBootInventoryAssignmentTests {

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
	Catalog catalog1 = null;
	
	@Before
	void setUp() {
		MockitoAnnotations.initMocks(this);
		
		supplier = new Supplier();
		supplier.setSupplierName("A");
		supplier.setSupplierId(1);
		
		catalog = new Catalog();
		catalog.setSkuCode(201);
		catalog.setbName("HaldiRam");
		catalog.setbDesc("Tasty and Crispy eatbles");
		catalog.setSkuName("HaldiRam Namkeen");
		catalog.setSupplier(supplier);
		
		catalog1 = new Catalog();
		catalog.setSkuCode(202);
		catalog1.setbName("HaldiRam");
		catalog1.setbDesc("Tasty and Sweet eatbles");
		catalog1.setSkuName("HaldiRam Sweets");
		catalog1.setSupplier(supplier);
		
		List<Catalog> list = new ArrayList<Catalog>();
		list.add(catalog);
		list.add(catalog1);
		supplier.setCatalogList(list);
	}
	

	
	@Test
	public void insertCatalogTest() {
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
	
	@Test
	public void getSKUNameListTest() {
		setUp();
		List<String> list1 = new ArrayList<String>();
		list1.add(catalog.getSkuName());
		when(catalogRepository.getSKUName(1, "HaldiRam")).thenReturn(list1);
		assertEquals(list1,catalogSevice.getSKUNameList(1, "HaldiRam"));
	}

}
