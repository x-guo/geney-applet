package com.geney.test;

import com.geney.dal.entity.UserDO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.geney.service.UserService;
import com.geney.testservice.TestService;

public class TestJunit extends TestService{

	@Autowired
	private UserService userService;
	
	@Test
	public void selectUserById(){
		/*UserDO user = userService.selectUserById(1);
		System.out.println(user.getUserName() + "+++++" + user.getPassword());*/
	}
	@Test
	public void testShiro() {
		Factory<SecurityManager> managerFactory = new IniSecurityManagerFactory("classpath:properties/shiro.ini");
		//首先创建一个管理工厂用于读取用户信息
		//		获取securityManager实例
		SecurityManager securityManager = managerFactory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		//得到subject及创建用户名密码的token
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123");
		//身份验证
		try {
			subject.login(token);
		} catch (AuthenticationException ae) {
			System.out.println("[用户]" + token.getUsername() + "认证失败");
			ae.printStackTrace();
		}
		Assert.assertEquals(true,subject.isAuthenticated());//断言已经通过认证
		subject.logout();
	}
}
