package com.hex.shopec.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Shopping_cart")
public class ShoppingCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer   		id;
	
	private String 			refernceno;
	
	@Column(name = "userid")
	private Integer 		userId;
	
	private Boolean 		active;
	
	private Date 			expiry;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "shoppingCart", cascade = CascadeType.ALL)
	private Set<ShoppingCartDetails> items = new HashSet<ShoppingCartDetails>();
	
	@OneToOne(mappedBy="shoppingCart",cascade = CascadeType.ALL)
	private Order 			order;
	
	public ShoppingCart() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRefernceno() {
		return refernceno;
	}

	public void setRefernceno(String refernceno) {
		this.refernceno = refernceno;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Temporal(TemporalType.DATE)
	public Date getExpiry() {
		return expiry;
	}

	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}

	
	public Set<ShoppingCartDetails> getItems() {
		return items;
	}

	public void setItems(Set<ShoppingCartDetails> items) {
		this.items = items;
		for(ShoppingCartDetails sd : items ) {
			sd.setShoppingCart(this);
		}
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		order.setShoppingCart(this);
		System.out.println(" -- ======= " + order.getTotalPrice());
		this.order = order;
	}
}
