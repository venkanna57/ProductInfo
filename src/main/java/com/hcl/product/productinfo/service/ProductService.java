package com.hcl.product.productinfo.service;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
	public OrderResDto placeOrder(OrderReqDto orderReqDto) {
		logger.info("inside order service:  ");
		OrderResDto orderResDto = new OrderResDto();
		String message = "Order placed successfully";
		List<OrderDto> requestOrder = orderReqDto.getItemList();

		double totalCost = 0.00;
		for (OrderDto order : requestOrder) {

			String itemName = order.getItemName();
			Item item = itemRepository.findByItemName(order.getItemName());
			totalCost = totalCost + (item.getItemCost() * order.getQuantity());
		}
	
}
