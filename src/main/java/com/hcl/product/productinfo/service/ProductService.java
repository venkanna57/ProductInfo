package com.hcl.product.productinfo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.product.productinfo.repository.ProductRepository;

@Service
public class ProductService {
	private static Logger logger = LoggerFactory.getLogger(ProductService.class);
	
	@Autowired
	ProductRepository productRepository;

	public void searchProduct(String productName) {
		logger.info("In ProductService searchProduct api : ");
		
		
	}
	

}
