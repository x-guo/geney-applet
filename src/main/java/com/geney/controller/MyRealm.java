package com.geney.controller;

import com.geney.common.ShiroPrincipal;
import com.geney.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by guozhenyu on 2016/7/20.
 */
@Service
@Transactional
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    public MyRealm() {
        super();
        setAuthenticationTokenClass(UsernamePasswordToken.class);
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //首先获取登录用户的用户名
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        ShiroPrincipal subject = (ShiroPrincipal)getAvailablePrincipal(principalCollection);
        String userName = subject.getUserName();
        Long userId = subject.getUserId();

        if(!subject.isAuthorized()){
            //获取该用户认证权限列表
            List<String> authorities = userService.getAuthorities(userId);
            List<String> roles = userService.getRoles(userId);
            subject.setAuthorities(authorities);
            subject.setRoles(roles);
            subject.setAuthorized(true);
            System.out.println("[用户]" + userName + "已经授权成功");
        }
        info.addStringPermissions(subject.getAuthorities());
        info.addRoles(subject.getRoles());
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        return null;
    }
}
