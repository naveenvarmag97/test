package com.hex.shopec.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Shopping_cart_details")
public class ShoppingCartDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer   		id;
	
	
	//private Integer 		shoppingCartid;
	
	@Column(name="productid")
	private Integer 		productId; 
	
	private BigDecimal		price;
	
	private Integer 		quantity;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shoppingcartid", nullable = false, insertable=true, updatable=false)
	private ShoppingCart 	shoppingCart;  
	
	public ShoppingCartDetails() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/*public Integer getShoppingCartid() {
		return shoppingCartid;
	}

	public void setShoppingCartid(Integer shoppingCartid) {
		this.shoppingCartid = shoppingCartid;
	}
*/
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
}
