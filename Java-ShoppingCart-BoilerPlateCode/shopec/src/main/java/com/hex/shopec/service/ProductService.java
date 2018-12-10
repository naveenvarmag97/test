package com.hex.shopec.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hex.shopec.model.Product;

@Service
public interface ProductService {
	
	List<Product> getAll();
}
