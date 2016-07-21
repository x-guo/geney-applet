package com.geney.common;

import com.geney.dal.entity.UserDO;

import java.io.Serializable;
import java.util.*;

/**
 * 自定义认证实体
 * Created by guozhenyu on 2016/7/20.
 */
public class ShiroPrincipal implements Serializable {


    private static final long serialVersionUID = -2886484607750306949L;

    /**
     * 用户对象
     */
    private UserDO user;

    /*用户权限列表*/
    private List<String> authorities = new ArrayList<String>();

    /*用户角色*/
    private List<String> roles = new ArrayList<String>();

    /*是否已经授权*/
    private boolean isAuthorized = false;

    public ShiroPrincipal() {
    }

    public ShiroPrincipal(UserDO user) {
        this.user = user;
    }

    public UserDO getUser() {
        return user;
    }

    public void setUser(UserDO user) {
        this.user = user;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }

    public void setAuthorized(boolean authorized) {
        isAuthorized = authorized;
    }

    /*获取用户名和用户id*/
    public String getUserName(){
        return  user.getUserName();
    }
    public Long getUserId(){
        return  user.getId();
    }

    @Override
    public String toString() {
        return "ShiroPrincipal{" +
                "user=" + user +
                '}';
    }
}
