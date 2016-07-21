package com.geney.controller;

import com.geney.dal.entity.UserDO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.eclipse.jetty.server.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by guozhenyu on 2016/7/21.
 */
@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(UserDO user, Model model, HttpServletRequest request){

       Subject subject =  SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),user.getPassword());
        String remember =  WebUtils.getCleanParam(request,"remember");
        logger.info("remember = " + remember);

        if (remember != null && remember.equals("on")){
            token.setRememberMe(true);
        }
        subject.login(token);
        return "redirect:/index";
    }

}
