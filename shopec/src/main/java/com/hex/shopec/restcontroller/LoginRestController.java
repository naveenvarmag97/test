package com.hex.shopec.restcontroller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hex.shopec.model.User;
import com.hex.shopec.service.UserService;


@RestController
@RequestMapping("account")
public class LoginRestController {

	private static final Logger log = LoggerFactory.getLogger(LoginRestController.class);
	
	@Autowired
	private UserService userService; 
	

	// this is the login api/service
	
	@RequestMapping("/login")
	public Principal user(Principal principal) {
		log.info("user logged "+principal);
		System.out.println("-------------------");
	//	User u = (User) principal;
	//	u.setPassword("******");
		return principal;
	}

	
	/*@PostMapping("/login")
	public String authorize(String username){
		log.debug("user login");
		
		//ssuserService.authenticateUser(loginid, password)
		
		return "success";
	}*/
}
