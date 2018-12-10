package com.hex.shopec.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hex.shopec.model.Product;
import com.hex.shopec.service.ProductService;

@CrossOrigin
@RestController
//@RequestMapping("/products")
public class ProductRestController {

	private static final Logger log = LoggerFactory.getLogger(ProductRestController.class);
	
	@Autowired
	private ProductService productService; 
	
	//@GetMapping("products/list")
	@RequestMapping(value = "/products/list")
	public List<Product> getAllProducts(){
		log.debug("getting all products");
		
		List<Product> products = productService.getAll();
		
		return products;
	}
}
