package com.peter.myport;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.peter.myport.friend.Friend;
import com.peter.myport.friend.FriendDAO;
import com.peter.myport.sns.SnsDAO;
import com.peter.myport.user.User;
import com.peter.myport.user.UserDAO;

@Controller
public class HomeController {
	
	@Autowired
	private SnsDAO sDAO;
	
	@Autowired
	private UserDAO uDAO; 
	
	@Autowired
	private FriendDAO fDAO;
	
	// sns main
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(User u, Friend f, HttpServletRequest req) {
		sDAO.countAllMsg();
		
		if(req.getSession().getAttribute("loginUser") != null) {
			fDAO.selectFriend(f, req);
			fDAO.selectSummitedList(f, req);			
			uDAO.selectAllUser(u, f , req);
		}
		sDAO.selectSns(1, req);
			
		
		return "index";
	}
	
}
