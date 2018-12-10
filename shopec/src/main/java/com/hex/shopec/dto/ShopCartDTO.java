package com.hex.shopec.dto;

import java.util.List;

public class ShopCartDTO {

	private String			orderId;
	private Integer			userId;
	private List<CartItem> 	items;
	private String 			deliveryOptionCode;
	private Double 			grossTotal			= 0.0;
	private Double 			deliveryTotal 		= 0.0;
	private Double 			itemsTotal 			= 0.0;
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getDeliveryOptionCode() {
		return deliveryOptionCode;
	}
	public void setDeliveryOptionCode(String deliveryOptionCode) {
		this.deliveryOptionCode = deliveryOptionCode;
	}
	public Double getGrossTotal() {
		return grossTotal;
	}
	public void setGrossTotal(Double grossTotal) {
		this.grossTotal = grossTotal;
	}
	public Double getDeliveryTotal() {
		return deliveryTotal;
	}
	public void setDeliveryTotal(Double deliveryTotal) {
		this.deliveryTotal = deliveryTotal;
	}
	public Double getItemsTotal() {
		return itemsTotal;
	}
	public void setItemsTotal(Double itemsTotal) {
		this.itemsTotal = itemsTotal;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public List<CartItem> getItems() {
		return items;
	}
	public void setItems(List<CartItem> items) {
		this.items = items;
	}
	
}

class CartItem{
	private Integer 	productId;	
	private Integer		quantity;
	private Double		price;
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
