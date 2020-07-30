package com.hcl.product.productinfo.dto;

import java.util.List;

import com.hcl.product.productinfo.entity.Product;

public class ProductResponseDto {
	
	private List<Product> products ; 
	
	private Integer statusCode;
	
	private String statusMessage;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
	

}
