package com.hcl.product.productinfo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.product.productinfo.controller.ProductController;
import com.hcl.product.productinfo.dto.ProductRequestDto;
import com.hcl.product.productinfo.dto.ProductResponseDto;
import com.hcl.product.productinfo.entity.Product;
import com.hcl.product.productinfo.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	private static Logger logger = LoggerFactory.getLogger(ProductService.class);
	
	public ProductResponseDto placeOrder(ProductRequestDto productRequestDto) {
		Product product = new Product();
		BeanUtils.copyProperties(productRequestDto, product);
		productRepository.save(product);
		ProductResponseDto productResponseDto = new ProductResponseDto();
		productResponseDto.setStatusCode(200);
		productResponseDto.setMessage("Product Purchased Successfully");
		logger.info("buy product");
		return productResponseDto;
		
	
}
}