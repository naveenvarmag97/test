package com.hex.shopec;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hex.shopec.dto.ShopCartDTO;
import com.hex.shopec.model.Order;
import com.hex.shopec.model.ShoppingCart;
import com.hex.shopec.repository.ShoppingCartRepository;
import com.hex.shopec.service.OrderServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

	@InjectMocks
	OrderServiceImpl service;
	
	@Mock
	ShoppingCartRepository repository;
	
	@Test
	public void placeOrderTest() {
		ShopCartDTO dto = new ShopCartDTO();
		dto.setUserId(1111);
		dto.setDeliveryOptionCode("DDD");
		dto.setDeliveryTotal(100.0);
		dto.setItemsTotal(10.3);
		dto.setGrossTotal(90.0);
		List items = new ArrayList<>();
		items.add(1);
		items.add(2);
		dto.setItems(items);
		Order order = new Order();
		order.setDeliveryType(dto.getDeliveryOptionCode());
		order.setOrderdate(new java.util.Date());
		order.setTotalPrice(dto.getGrossTotal());
		order.setId(111);
		ShoppingCart cart = new ShoppingCart();
		cart.setOrder(order);
		Mockito.when(repository.save(Mockito.any(ShoppingCart.class))).thenReturn(cart);
		ShopCartDTO dto1 = service.placeOrder(dto);;
		assertEquals(dto1.getOrderId(),cart.getOrder().getId().toString());
		
		
	}
}
