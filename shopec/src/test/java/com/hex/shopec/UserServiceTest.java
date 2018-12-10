package com.hex.shopec;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hex.shopec.model.User;
import com.hex.shopec.repository.UserRepository;
import com.hex.shopec.service.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
	@InjectMocks
	UserServiceImpl service;
	
	@Mock
	UserRepository repository;

	@Test
	public void findByLoginidTest(){
		User user1 = new User();
		user1.setId(1111);
		Mockito.when(repository.findByUsername("1111")).thenReturn(user1);
		User user = service.findByLoginid("1111");
		assertEquals(user1.getId(), user.getId());
	}
	
	@Test
	public void createTest(){
		User user1 = new User();
		user1.setId(1111);
		User user2 = new User();
		user2.setId(1111);
		Mockito.when(repository.save(user1)).thenReturn(user2);
		User user = service.create(user1);
		assertEquals(user1.getId(), user.getId());
	}
	
	@Test
	public void authenticateUSerTest(){
		User user = new User();
		user.setId(1111);
		user.setPassword("password");
		Mockito.when(repository.findByUsername("1111")).thenReturn(user);
		User user1 = service.authenticateUser("1111", "password");
		Assert.assertEquals(user1.getPassword(), user.getPassword());
		
	}
}
