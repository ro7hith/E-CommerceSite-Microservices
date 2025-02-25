package com.microservices.order_service.order_service.dto;

import java.util.List;



public class OrderRequest {

	private List<OrderItemsDto> orderItemsDtos;

	public OrderRequest() {
		super();
	}

	public OrderRequest(List<OrderItemsDto> orderItemsDtos) {
		super();
		this.orderItemsDtos = orderItemsDtos;
	}

	public List<OrderItemsDto> getOrderItemsDtos() {
		return orderItemsDtos;
	}

	public void setOrderItemsDtos(List<OrderItemsDto> orderItemsDtos) {
		this.orderItemsDtos = orderItemsDtos;
	}
	
}
