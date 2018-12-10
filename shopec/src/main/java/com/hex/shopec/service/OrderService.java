package com.hex.shopec.service;

import com.hex.shopec.dto.ShopCartDTO;
import com.hex.shopec.model.ShoppingCart;


public interface OrderService {
	
	ShopCartDTO placeOrder(ShopCartDTO shoppingCartDto);
	

}
