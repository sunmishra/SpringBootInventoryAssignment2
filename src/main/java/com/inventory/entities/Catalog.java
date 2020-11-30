package com.inventory.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "catalog")
public class Catalog {

	@Id
	@Column(length = 50)
	// @GeneratedValue
	private int skuCode;
	@Column(length = 50)
	private String skuName;
	@Column(length = 50)
	private String skuDesc;
	@Column(length = 50)
	private String bName;
	@Column(length = 50)
	private String bDesc;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "supplier_id", nullable = false, unique = true)
	@JsonManagedReference
	@JsonIgnore
	private Supplier supplier;// FK

	public Catalog() {
	}

	public Catalog(int skuCode, String skuName, String skuDesc, String bName, String bDesc, Supplier supplier) {
		this.skuCode = skuCode;
		this.skuName = skuName;
		this.skuDesc = skuDesc;
		this.bName = bName;
		this.bDesc = bDesc;
		this.supplier = supplier;
	}

	public int getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(int skuCode) {
		this.skuCode = skuCode;
	}

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public String getSkuDesc() {
		return skuDesc;
	}

	public void setSkuDesc(String skuDesc) {
		this.skuDesc = skuDesc;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbDesc() {
		return bDesc;
	}

	public void setbDesc(String bDesc) {
		this.bDesc = bDesc;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	@Override
	public String toString() {
		return "Catalog [skuCode=" + skuCode + ", skuName=" + skuName + ", skuDesc=" + skuDesc + ", bName=" + bName
				+ ", bDesc=" + bDesc + ", supplier=" + supplier + "]";
	}

}
