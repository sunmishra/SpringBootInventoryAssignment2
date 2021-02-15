package com.inventory.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "supplier")
public class Supplier {

	@Id
	@Column(length = 50)
	private int supplierId;
	@Column(length = 50)
	private String supplierName;
	@OneToMany(mappedBy = "supplier", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JsonBackReference
	private List<Catalog> catalogList;

	public Supplier() {
		this.catalogList = new ArrayList<Catalog>();
	}

	public Supplier(int supplierId, String supplierName) {
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.catalogList = new ArrayList<Catalog>();
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public List<Catalog> getCatalogList() {
		return catalogList;
	}

	public void setCatalogList(List<Catalog> catalogList) {
		this.catalogList = catalogList;
	}

	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", supplierName=" + supplierName + ", catalogList=" + catalogList
				+ "]";
	}

}
