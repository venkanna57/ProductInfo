package com.hcl.product.productinfo.dto;

import java.util.List;

import com.hcl.product.productinfo.entity.OrderDetail;

public class OrderDetailResponseDto {
	
	private List<OrderDetail> orderDetails ; 
	
	private Integer statusCode;
	
	private String statusMessage;



	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
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
