package com.hcl.product.productinfo.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.hcl.product.productinfo.controller.ProductController;
import com.hcl.product.productinfo.dto.ProductRequestDto;
import com.hcl.product.productinfo.dto.ProductResponseDto;
import com.hcl.product.productinfo.dto.ReviewRequestDto;
import com.hcl.product.productinfo.dto.ReviewResponseDto;
import com.hcl.product.productinfo.entity.Product;
import com.hcl.product.productinfo.entity.User;
import com.hcl.product.productinfo.repository.ProductOrderRepository;
import com.hcl.product.productinfo.repository.ProductRepository;
import com.hcl.product.productinfo.repository.ReviewRepository;
import com.hcl.product.productinfo.repository.UserRepository;
import com.hcl.product.productinfo.entity.*;
/**
 * This application related to E-cart for online purchase and review comments
 * @author Venkanna G
 * @since 29-07-2020
 *
 */
@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ProductOrderRepository productOrderRepository;
	@Autowired
	ReviewRepository reviewRepository;
	
	private static Logger logger = LoggerFactory.getLogger(ProductService.class);
	
	/**
	 * 
	 * @param productRequestDto
	 * @return productResponseDto
	 */
	public ProductResponseDto placeOrder(ProductRequestDto productRequestDto) {
		Product product = new Product();
		BeanUtils.copyProperties(productRequestDto, product);
		productRepository.save(product);
		ProductResponseDto productResponseDto = new ProductResponseDto();
		productResponseDto.setStatusCode(200);
		productResponseDto.setMessage("Product purchased successfully");
		logger.info("buy product");
		return productResponseDto;
	}

	/**
	 * 
	 * @param userId
	 * @param reviewRequestDto
	 * @return ReviewResponseDto
	 */
	public ReviewResponseDto giveRatings(Integer userId, ReviewRequestDto reviewRequestDto){
		ReviewResponseDto reviewResponseDto = new ReviewResponseDto();
		Optional<User> users = userRepository.findByUserId(userId);
		Integer productId = reviewRequestDto.getProductId();
		logger.info("ProductId======"+productId);
		Optional<Product> products = productRepository.findByProductId(productId);
		if (users.isPresent()) {
			User user = users.get();
			logger.info("UserId======="+user.getUserId());
			if (products.isPresent()) {
				Product product = products.get();
				Optional<Orders> productOrders = productOrderRepository.findByProduct(product);
				
				if (productOrders.isPresent()) {
					
					Orders productOrder = productOrders.get();
					OrderDetail orderDetail = productOrder.getOrderDetail();
					logger.info("Order details======="+orderDetail.getOrderDetailId());
					if (orderDetail.getUser().getUserId().equals(userId)) {
						Optional<Rating> reviews = reviewRepository.findByProductAndUser(product, user);
						logger.info("Reviews: "+reviews);
						if (!reviews.isPresent()) {
							
							Rating rating = new Rating();
							logger.info("reviews: "+rating.getReview());
							BeanUtils.copyProperties(reviewRequestDto, rating);
							rating.setProduct(product);
							rating.setUser(orderDetail.getUser());
							reviewRepository.save(rating);
							Integer productRating = (reviewRequestDto.getProductRating() + product.getProductRating())
									/ 2;
							product.setProductRating(productRating);
							productRepository.save(product);
							reviewResponseDto.setStatusMessage("Reviewed successfully");
							reviewResponseDto.setStatusCode(HttpStatus.OK.value());
						} 
						
					}
				else {
							reviewResponseDto.setStatusMessage("Already Reviewed");
							reviewResponseDto.setStatusCode(HttpStatus.OK.value());
						}
					}
				}	
			
		
		}
		
		return reviewResponseDto;
	}
}
				
