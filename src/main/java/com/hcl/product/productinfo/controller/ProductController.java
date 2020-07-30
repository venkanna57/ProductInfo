package com.hcl.product.productinfo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.product.productinfo.dto.OrderDetailResponseDto;
import com.hcl.product.productinfo.dto.ProductResponseDto;
import com.hcl.product.productinfo.exception.ProductNotAvailableException;
import com.hcl.product.productinfo.exception.UserNotFoundException;
import com.hcl.product.productinfo.service.ProductService;

/**
 * This application related to E-cart searching product and getting order details
 * @author Rajesh R
 * @since 29-07-2020
 *
 */

@RestController
@RequestMapping("/products")
public class ProductController {
	private static Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductService productService;
	
	/**
	 * 
	 * @param productName String value type
	 * @return ProductResponseDto
	 * @throws ProductNotAvailableException if product not present throws ProductNotAvailableException
	 */
	
	@GetMapping("")
	public ResponseEntity<ProductResponseDto> searchProduct(@RequestParam String productName) throws ProductNotAvailableException {
		logger.info("In ProductController searchProduct api : ");
		ProductResponseDto productResponseDto = productService.searchProduct(productName);
		return new ResponseEntity<>(productResponseDto,HttpStatus.CREATED);
	}
	
	/**
	 * 
	 * @param userId Integer value type
	 * @return OrderDetailResponseDto
	 * @throws UserNotFoundException if user not present throws UserNotFoundException
	 */
	
	@GetMapping("/{userId}/orders")
	public ResponseEntity<OrderDetailResponseDto> orderDetails(@RequestParam Integer userId) throws UserNotFoundException {
		OrderDetailResponseDto orderDetailResponseDto =productService.orderDetails(userId);
		return new ResponseEntity<>(orderDetailResponseDto,HttpStatus.OK);
	}
	
	

}
