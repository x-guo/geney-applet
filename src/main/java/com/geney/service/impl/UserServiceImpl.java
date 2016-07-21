package com.geney.service.impl;

import com.geney.dal.entity.UserDO;
import com.geney.dal.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geney.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	private UserMapper  userMapper;

	public UserDO selectUserById(Long id) {
		return  userMapper.selectUserById(id);
	}
	public List<String> getAuthorities(Long userId){
		return  userMapper.getAuthorities(userId);
	}

	public List<String> getRoles(Long userId) {
		return userMapper.getRoles(userId);
	}
}
