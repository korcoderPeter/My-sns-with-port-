package com.peter.myport.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.peter.myport.user.User;

@Controller
public class LoginController {
	
	@Autowired
	private LoginDAO lDAO;

	// 로그인 페이지
	@RequestMapping(value = "/loginPage.com", method =RequestMethod.GET)
	public String loginPage() {
		return "user/login";
	}
	
	
	// 회원가입 페이지
	@RequestMapping(value ="/joinPage.com", method = RequestMethod.GET)
	public String joinPage() {
		
		return "user/join";
	}
	
	
	// 가입
	@RequestMapping(value = "/join.com", method = RequestMethod.POST)
	public String join(HttpServletRequest req) {
		
		lDAO.join(req);
		
		return "index";
	}
	// 로그인
	@RequestMapping(value = "/login.com", method = RequestMethod.POST)
	public String login(User u, HttpServletRequest req) {
		
		lDAO.login(u, req);
		
		return "index";
	}
	
	// 로그아웃
	@RequestMapping(value = "/logout.com", method = RequestMethod.GET)
	public String login(HttpServletRequest req) {
		
		lDAO.logout(req);
		
		return "index";
	}
	
}
