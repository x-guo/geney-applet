package com.geney.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geney.dal.UserDO;
import com.geney.entity.User;
import com.geney.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDO userDO;
	
	public User selectUserById(Integer userId) {
		return userDO.selectUserById(userId);
	}

}
