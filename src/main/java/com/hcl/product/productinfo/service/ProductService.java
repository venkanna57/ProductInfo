package com.hcl.product.productinfo.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.product.productinfo.config.ApplicationConstant;
import com.hcl.product.productinfo.dto.ProductResponseDto;
import com.hcl.product.productinfo.entity.Product;
import com.hcl.product.productinfo.exception.ProductNotAvailableException;
import com.hcl.product.productinfo.repository.ProductRepository;

@Service
public class ProductService {
	private static Logger logger = LoggerFactory.getLogger(ProductService.class);
	
	@Autowired
	ProductRepository productRepository;

	public ProductResponseDto searchProduct(String productName) throws ProductNotAvailableException {
		logger.info("In ProductService searchProduct api : ");
		ProductResponseDto productResponseDto = new ProductResponseDto();
		List<Product> productList = new ArrayList<>();
		Optional<List<Product>> products = productRepository.findByProductNameContains(productName);
		if(products.isPresent()) {
			 productList = products.get();
		List<Product> list = productList.stream().sorted(Comparator.comparing(Product::getProductRating).reversed()).collect(Collectors.toList());
		productResponseDto.setProducts(list);
		productResponseDto.setStatusCode(ApplicationConstant.STATUS_CODE_200);
		productResponseDto.setStatusMessage(ApplicationConstant.SUCCESS);
		return productResponseDto;
		}
		else
			throw new ProductNotAvailableException(ApplicationConstant.PRODUCT_NOT_AVAILABLE);
	}
	

}
