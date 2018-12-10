package com.hex.shopec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hex.shopec.model.ShoppingCart;

@Repository
public interface  ShoppingCartRepository  extends JpaRepository<ShoppingCart, Long> {


}
