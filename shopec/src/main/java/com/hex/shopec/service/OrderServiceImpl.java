package com.hex.shopec.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hex.shopec.dto.ShopCartDTO;
import com.hex.shopec.model.Order;
import com.hex.shopec.model.ShoppingCart;
import com.hex.shopec.repository.ShoppingCartRepository;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class); 
			
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	@Autowired
	private ModelMapper modelMapper = new ModelMapper();
	

	@Override
	public ShopCartDTO placeOrder(ShopCartDTO shoppingCartDto) {
		
		modelMapper.getConfiguration()
		  .setMatchingStrategy(MatchingStrategies.STRICT);	
		
		ShoppingCart shoppingCart = modelMapper.map(shoppingCartDto, ShoppingCart.class);
		
		log.debug(  shoppingCart.getUserId().toString() );
		
		shoppingCart.setRefernceno(UUID.randomUUID().toString());
		shoppingCart.setActive(true);
		shoppingCart.setExpiry(new java.util.Date());
		
		Order order = new Order();
		
		order.setDeliveryType(shoppingCartDto.getDeliveryOptionCode());
		order.setOrderdate(new java.util.Date());
		order.setProductsPurchased(shoppingCartDto.getItems().size());
		order.setTotalPrice(shoppingCartDto.getGrossTotal());
		
		shoppingCart.setOrder(order);
		
		shoppingCart = shoppingCartRepository.save(shoppingCart);
		 
		shoppingCartDto = modelMapper.map(shoppingCart, ShopCartDTO.class);
		shoppingCartDto.setOrderId(shoppingCart.getOrder().getId().toString()); 
		return shoppingCartDto;
	}

	
	
}
