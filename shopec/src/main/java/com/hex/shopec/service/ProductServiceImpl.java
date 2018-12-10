package com.hex.shopec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hex.shopec.model.Product;
import com.hex.shopec.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}
	
		
}
