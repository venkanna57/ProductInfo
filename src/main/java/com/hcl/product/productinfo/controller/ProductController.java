package com.hcl.product.productinfo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.product.productinfo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	private static Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductService productService;
	
	@GetMapping("")
	public String searchProduct(@RequestParam String productName) {
		logger.info("In ProductController searchProduct api : ");
		productService.searchProduct(productName);
		return null;
		
	}
	
	

}
