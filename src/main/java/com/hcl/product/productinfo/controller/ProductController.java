package com.hcl.product.productinfo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.product.productinfo.dto.OrderRequestDto;
import com.hcl.product.productinfo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	ProductService productService;
	
	private static Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@PostMapping("/buyProduct")
	public ResponseEntity<OrderResDto> placeOrder(@RequestBody OrderRequestDto orderRequestDto){
		OrderResDto resDto = orderService.placeOrder(orderReqDto);
		return new ResponseEntity<>(resDto, HttpStatus.CREATED);
	}
	
	
	
}
