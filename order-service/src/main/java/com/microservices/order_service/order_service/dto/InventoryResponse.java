package com.microservices.order_service.order_service.dto;

public class InventoryResponse {
    private String skuCode;
    private boolean isInStock;
	public InventoryResponse() {
		super();
	}
	public InventoryResponse(String skuCode, boolean isInStock) {
		super();
		this.skuCode = skuCode;
		this.isInStock = isInStock;
	}
	public String getSkuCode() {
		return skuCode;
	}
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
	public boolean isInStock() {
		return isInStock;
	}
	public void setInStock(boolean isInStock) {
		this.isInStock = isInStock;
	}
}
