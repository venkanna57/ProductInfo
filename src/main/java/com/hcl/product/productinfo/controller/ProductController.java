package com.hcl.product.productinfo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.product.productinfo.dto.ProductRequestDto;
import com.hcl.product.productinfo.dto.ProductResponseDto;
import com.hcl.product.productinfo.dto.ReviewRequestDto;
import com.hcl.product.productinfo.dto.ReviewResponseDto;
import com.hcl.product.productinfo.service.ProductService;
/**
 * This application related to E-cart for online purchase and review comments
 * @author Venkanna G
 * @since 29-07-2020
 *
 */
@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	ProductService productService;
	
	private static Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	/**
	 * 
	 * @param productRequestDto
	 * @return productResponseDto
	 */
	@PostMapping("/buyProduct")
	public ResponseEntity<ProductResponseDto> placeOrder(@RequestBody ProductRequestDto productRequestDto){
		ProductResponseDto productResponseDto = productService.placeOrder(productRequestDto);
		return new ResponseEntity<>(productResponseDto, HttpStatus.CREATED);
	}
	
	/**
	 * 
	 * @param userId
	 * @param reviewRequestDto
	 * @return ReviewResponseDto
	 */
	@PostMapping("/{userId}/review")
	public ResponseEntity<ReviewResponseDto> giveRatings(@PathVariable Integer userId, @RequestBody ReviewRequestDto reviewRequestDto) {
		ReviewResponseDto reviewResponseDto;
		reviewResponseDto = productService.giveRatings(userId, reviewRequestDto);
		return new ResponseEntity<>(reviewResponseDto, HttpStatus.OK);
	}
	
}
