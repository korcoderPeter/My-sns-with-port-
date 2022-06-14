package com.peter.myport.friend;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.peter.myport.sns.SnsDAO;
import com.peter.myport.user.User;
import com.peter.myport.user.UserDAO;

@Controller
public class FriendController {

	@Autowired
	private SnsDAO sDAO;
	
	@Autowired
	private UserDAO uDAO;
	
	@Autowired
	private FriendDAO fDAO;
	
	@RequestMapping(value = "/plusFriend", method = RequestMethod.POST)
	public String plusFriend(User u, Friend f, HttpServletRequest req) {
		
		uDAO.selectUserDetail(u, req);
		fDAO.insertFriend(f, req);
		
		return "sns/snsFriendPage";
	}
	@RequestMapping(value = "/acceptFriend", method = RequestMethod.GET)
	public String acceptFriend(User u, Friend f, HttpServletRequest req) {
		sDAO.countAllMsg();
		sDAO.selectSns( 1, req);
		uDAO.selectAllUser(u, f, req);
		if(req.getSession().getAttribute("loginUser") != null) {
			fDAO.selectFriend(f, req);
			fDAO.selectSummitedList(f, req);			
		}
		// 업데이트
		fDAO.acceptFriend(f, req);
		
		return "index";
	}
	
	
}
