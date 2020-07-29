package com.hcl.product.productinfo.dto;

import java.util.List;

import com.hcl.product.productinfo.entity.OrderDetail;

public class OrderDetailResponseDto {
	
	private List<OrderDetail> OrderDetails ; 
	
	private Integer statusCode;
	
	private String statusMessage;

	public List<OrderDetail> getOrderDetails() {
		return OrderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		OrderDetails = orderDetails;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
	

}
