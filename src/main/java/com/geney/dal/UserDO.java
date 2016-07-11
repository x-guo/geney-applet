package com.geney.dal;

import com.geney.entity.User;

public interface UserDO {

	User selectUserById(Integer userId);
	
}
