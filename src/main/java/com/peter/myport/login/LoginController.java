package com.peter.myport.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.peter.myport.friend.Friend;
import com.peter.myport.friend.FriendDAO;
import com.peter.myport.sns.SnsDAO;
import com.peter.myport.user.User;
import com.peter.myport.user.UserDAO;

@Controller
public class LoginController {
	
	@Autowired
	private LoginDAO lDAO;
	
	@Autowired
	private UserDAO uDAO; 
	
	@Autowired
	private FriendDAO fDAO;

	@Autowired
	private SnsDAO sDAO;
	
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
	public String join(HttpServletRequest req, Friend f, User u) {
		sDAO.countAllMsg();
		lDAO.join(req);
		sDAO.selectSns(1, req);
		if(req.getSession().getAttribute("loginUser") != null) {
			uDAO.selectAllUser(u, f, req);
			fDAO.selectFriend(f, req);
			fDAO.selectSummitedList(f, req);			
		}
		return "index";
	}
	// 로그인
	@RequestMapping(value = "/login.com", method = RequestMethod.POST)
	public String login(User u, HttpServletRequest req, Friend f) {
		sDAO.countAllMsg();
		lDAO.login(u, req);
		sDAO.selectSns(1, req);
		if(req.getSession().getAttribute("loginUser") != null) {
			uDAO.selectAllUser(u, f, req);
			fDAO.selectFriend(f, req);
			fDAO.selectSummitedList(f, req);			
		}
		return "index";
	}
	
	// 로그아웃
	@RequestMapping(value = "/logout.com", method = RequestMethod.GET)
	public String logout(User u, HttpServletRequest req, Friend f) {
		sDAO.countAllMsg();
		lDAO.logout(req);
		sDAO.selectSns(1, req);
		if(req.getSession().getAttribute("loginUser") != null) {
			uDAO.selectAllUser(u, f, req);
			fDAO.selectFriend(f, req);
			fDAO.selectSummitedList(f, req);			
		}
		return "index";
	}
	
}
