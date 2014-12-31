package com.zhuhaihuan.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class LoginController {
	@RequestMapping("home/login.do")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response){
	         String username = (String) request.getParameter("username");
	         String password = (String) request.getParameter("password");
	         ModelAndView mv = new ModelAndView("/index/home","command","LOGIN SUCCESS, " + username + " password:"+password);
	         return mv;
	}
}
