package com.peter.myport.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.peter.myport.sns.SnsDAO;

@Controller
public class UserController {

	@Autowired
	private UserDAO uDAO;
	
	@Autowired
	private SnsDAO sDAO;
	
	// 회원정보 페이지
	@RequestMapping(value = "/info.com", method = RequestMethod.GET)
	public String UserInfo() {
		return "user/info";
	}
	// 정보 수정
	@RequestMapping(value = "/updateInfo.com", method = RequestMethod.POST)
	public String UpdateInfo(User u, HttpServletRequest req) {
		
		uDAO.updateInfo(u, req);
		sDAO.selectSns(req);
		return "index";
	}
	// 탈퇴
	@RequestMapping(value = "/deleteUser.com", method = RequestMethod.POST)
	public String deleteUser(User u,HttpServletRequest req) {
		
		
		uDAO.deleteUser(u, req);
		sDAO.selectSns(req);
		return "index";
	}
	
}
