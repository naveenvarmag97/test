package com.hex.shopec.service;

import org.springframework.stereotype.Service;

import com.hex.shopec.model.User;


public interface UserService {
	User findByLoginid(String loginid);
	
	User create(User user);
	
	User authenticateUser(String loginid, String password);
}
