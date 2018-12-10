package com.hex.shopec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hex.shopec.model.User;

@Repository
public interface  UserRepository  extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
