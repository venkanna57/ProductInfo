package com.hcl.product.productinfo.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.product.productinfo.config.ApplicationConstant;
import com.hcl.product.productinfo.dto.OrderDetailResponseDto;
import com.hcl.product.productinfo.dto.ProductResponseDto;
import com.hcl.product.productinfo.entity.OrderDetail;
import com.hcl.product.productinfo.entity.Product;
import com.hcl.product.productinfo.entity.User;
import com.hcl.product.productinfo.exception.ProductNotAvailableException;
import com.hcl.product.productinfo.exception.UserNotFoundException;
import com.hcl.product.productinfo.repository.OrderDetailRepository;
import com.hcl.product.productinfo.repository.ProductRepository;
import com.hcl.product.productinfo.repository.UserRepository;

/**
 * This application related to E-cart searching product and getting order details
 * @author Rajesh R
 *@since 29-07-2020
 *
 */

@Service
public class ProductService {
	private static Logger logger = LoggerFactory.getLogger(ProductService.class);
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	OrderDetailRepository orderDetailRepository;
	
	/**
	 * 
	 * @param productName String value type
	 * @return ProductResponseDto
	 * @throws ProductNotAvailableException if product not present throws ProductNotAvailableException
	 */
	public ProductResponseDto searchProduct(String productName) throws ProductNotAvailableException {
		logger.info("In ProductService searchProduct api : ");
		ProductResponseDto productResponseDto = new ProductResponseDto();
		List<Product> productList ;
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

	/**
	 * 
	 * @param userId Integer value type
	 * @return OrderDetailResponseDto
	 * @throws UserNotFoundException if user not present throws UserNotFoundException
	 */
	public OrderDetailResponseDto orderDetails(Integer userId) throws UserNotFoundException {
		logger.info("In ProductService orderDetails api : ");
	OrderDetailResponseDto orderDetailResponseDto = new OrderDetailResponseDto();
	Optional<User>	user = userRepository.findByUserId(userId);
	if(user.isPresent()) {
		User user2 = user.get();
		List<OrderDetail> orderDetails = orderDetailRepository.findByUserId(user2.getUserId());
		orderDetailResponseDto.setOrderDetails(orderDetails);
		orderDetailResponseDto.setStatusCode(ApplicationConstant.STATUS_CODE_200);
		orderDetailResponseDto.setStatusMessage(ApplicationConstant.SUCCESS);
		return orderDetailResponseDto;
	}else
		throw new UserNotFoundException(ApplicationConstant.USER_NOT_FOUND);
	}
	

}
