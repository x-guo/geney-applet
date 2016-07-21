package com.geney.service;

import com.geney.dal.entity.UserDO;

import java.util.List;

public interface UserService {
    UserDO	selectUserById(Long id);
    List<String> getAuthorities(Long userId);
    List<String> getRoles(Long userId);
}
