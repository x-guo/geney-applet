package com.geney.dal.mapper;

import com.geney.dal.entity.UserDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by guozhenyu on 2016/7/20.
 */

@Repository
public interface UserMapper {
     UserDO selectUserById(Long id);
     List<String> getAuthorities(Long userId);
     List<String> getRoles(Long userId);
}
