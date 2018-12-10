package com.hex.shopec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hex.shopec.model.Product;
import com.hex.shopec.model.User;

@Repository
public interface  ProductRepository  extends JpaRepository<Product, Long> {

	List<Product> findAll();
}
