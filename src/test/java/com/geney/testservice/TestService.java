package com.geney.testservice;

import com.geney.dal.entity.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.geney.service.UserService;



@ContextConfiguration(locations = {"classpath:application.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestService extends AbstractJUnit4SpringContextTests{
	@Autowired
	private UserService userService;
	
	@Test
	public void selectUserById(){
		UserDO user = userService.selectUserById(1L);
		System.out.println(user.getUserName() + "+++++" + user.getPassword());
	}
	
}
