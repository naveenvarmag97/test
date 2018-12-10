package com.hex.shopec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hex.shopec.model.User;
import com.hex.shopec.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	
	@Override
	public User findByLoginid(String loginid) {
		// TODO Auto-generated method stub
		System.out.println("ssssssssssss" + loginid);
		return userRepository.findByUsername(loginid);
	}

	@Override
	public User create(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User authenticateUser(String loginid, String password) {
		// TODO Auto-generated method stub
		User user  = findByLoginid(loginid);
		if(user.getPassword().equals(password) )
				return user;
		return null;
	}
	
	
	
}
