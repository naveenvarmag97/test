package com.hex.shopec.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hex.shopec.model.User;


@Service("customUserDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {


  @Autowired
  private UserService userService ;
  
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    /*Here we are using dummy data, you need to load user data from
     database or other third party application*/
	System.out.println(" userName " + username);  
    User user = findUserbyUername(username);
    
    return user;
/*
    UserBuilder builder = null;
    if (user != null) {
      builder = org.springframework.security.core.userdetails.User.withUsername(username);
      //builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
      builder.password(user.getPassword());
      builder.roles("User");
    } else {
      throw new UsernameNotFoundException("User not found.");
    }

    return builder.build();
    */
  }

  private User findUserbyUername(String username) {
    /*if(username.equalsIgnoreCase("admin")) {
      return new User(username, "admin123", "ADMIN");
    }*/
    return userService.findByLoginid(username);
  }
}