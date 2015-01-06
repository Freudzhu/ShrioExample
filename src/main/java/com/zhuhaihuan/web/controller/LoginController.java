package com.zhuhaihuan.web.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class LoginController {

	@RequestMapping("home/login.do")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response){
		String message = "";
	
		try {
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				Subject subject = SecurityUtils.getSubject();
		        subject.login(new UsernamePasswordToken(username, password));
		       
		        if (subject.isAuthenticated()) {
		        	message = "登录成功";
		        } else {
		            message = "用户名/密码错误";
		        }
		 }catch (UnknownAccountException ex){
			 	message = "用户名/密码错误";
	            ex.printStackTrace();
		 }catch (AuthenticationException ex){
			 	message = "用户名/密码错误";
	            ex.printStackTrace();
	     }
	 
	        ModelAndView mv = new ModelAndView("/index/home","command","LOGIN SUCCESS, " + message);
	        return mv;
	}
	@RequestMapping("home/test.do")
	public ModelAndView test(HttpServletRequest request,HttpServletResponse response){
		
	        ModelAndView mv = new ModelAndView("/index/test","command","LOGIN SUCCESS, " + "test successsful");
	        return mv;
	}
}
