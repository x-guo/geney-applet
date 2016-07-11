package com.geney.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.geney.entity.User;
import com.geney.service.UserService;
import com.geney.testservice.TestService;

public class TestJunit extends TestService{

	@Autowired
	private UserService userService;
	
	@Test
	public void selectUserById(){
		User user = userService.selectUserById(1);
		System.out.println(user.getUserName() + "+++++" + user.getPassword());
	}
	
}
