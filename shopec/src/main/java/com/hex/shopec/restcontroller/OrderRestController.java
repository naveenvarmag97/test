package com.hex.shopec.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hex.shopec.dto.ShopCartDTO;
import com.hex.shopec.service.OrderService;

@CrossOrigin
@RestController
//@RequestMapping("/order")
public class OrderRestController {

	private static final Logger log = LoggerFactory.getLogger(OrderRestController.class);
	
	
	@GetMapping(value = "/order/get" )
	public String getPlaceOrder(){
		log.debug("creating order..");
		
		
		
		return "Success";
	}
	
	@Autowired
	private OrderService orderService; 
	
	@PostMapping(value = "/order/create", consumes = "application/json", produces = "application/json" )
	public String getPlaceOrder(@RequestBody ShopCartDTO shoppingCart){
		log.debug("creating order..");
		
		shoppingCart  = orderService.placeOrder(shoppingCart);
		
		return "{ \"orderNo\":"+shoppingCart.getOrderId()+"}";
	}
}
