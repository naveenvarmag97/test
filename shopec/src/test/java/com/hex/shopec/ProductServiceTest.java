package com.hex.shopec;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hex.shopec.model.Product;
import com.hex.shopec.repository.ProductRepository;
import com.hex.shopec.service.ProductServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
	
	@InjectMocks
	ProductServiceImpl serviceImpl;
	
	@Mock
	private ProductRepository productRepository;
	
	@Test
	public void getAllTest() {
		Product product = new Product();
		product.setId(111);
		Product product1 = new Product();
		product1.setId(222);
		List<Product> productList = new ArrayList<Product>();
		productList.add(product);
		productList.add(product1);
		Mockito.when(productRepository.findAll()).thenReturn(productList);
		List<Product> list = serviceImpl.getAll();
		Assert.assertEquals(productList.get(0).getId(), list.get(0).getId());
	}

}
