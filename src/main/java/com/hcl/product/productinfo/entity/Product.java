package com.hcl.product.productinfo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	private String productName;
	private String productDescription;
	private Integer productRating;

	@OneToOne
	@JoinColumn(name = "storeId")
	private Store store;

	public Integer getProductId() {
		return productId;
	}

	public Store getStore() {
		return store;
	}


	public void setStore(Store store) {
		this.store = store;
	}


	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Integer getProductRating() {
		return productRating;
	}

	public void setProductRating(Integer productRating) {
		this.productRating = productRating;
	}


}
