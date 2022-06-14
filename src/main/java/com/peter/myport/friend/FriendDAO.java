package com.peter.myport.friend;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peter.myport.user.User;

@Service
public class FriendDAO {
	
	
	@Autowired
	private SqlSession ss;
	
	
	public void insertFriend(Friend f, HttpServletRequest req) {
		String accept_user =  req.getParameter("user");
		String status = "summit";
		User user = (User) req.getSession().getAttribute("loginUser");;
		String summit_user = user.getUserName();
		System.out.println(accept_user);
		System.out.println(status);
		System.out.println(summit_user);
		
		f.setAccept_user(accept_user);
		f.setStatus(status);
		f.setSummit_user(summit_user);
		if(ss.getMapper(FriendMapper.class).insertFriend(f)== 1) {
			System.out.println("친구 신청 완료");
		}
		
	}
	public void selectSummitedList(Friend f, HttpServletRequest req) {
		User user = (User) req.getSession().getAttribute("loginUser");;
		String accept_user = user.getUserName();
		f.setStatus("summit");
		f.setAccept_user(accept_user);
		List<Friend> selectSummitedList = ss.getMapper(FriendMapper.class).selectSummitedList(f);
		req.setAttribute("selectSummitedList", selectSummitedList);
		
	}
	public void acceptFriend(Friend f, HttpServletRequest req) {
		User user = (User) req.getSession().getAttribute("loginUser");;
		String accept_user = user.getUserName(); 
		System.out.println(accept_user);
		f.setAccept_user(accept_user); // 나
		String accept = "accept";
		f.setStatus(accept); // 수락
		String summit_user = req.getParameter("summit_user");
		System.out.println(summit_user+"zz");
		f.setSummit_user(summit_user); // 신청한 상대
		
		if(ss.getMapper(FriendMapper.class).acceptFriend(f) == 1) {
			System.out.println("수락성공");
		}else {
			System.out.println("실패");
		}
		
	}
	
	public void selectFriend(Friend f, HttpServletRequest req) {
		User user = (User) req.getSession().getAttribute("loginUser");
		f.setAccept_user(user.getUserName());
		f.setStatus("accept");
		f.setSummit_user(user.getUserName());
		List<Friend> selectFriend = ss.getMapper(FriendMapper.class).selectFriend(f);
		 		
		ArrayList<String> friendNameList = new ArrayList<String>();
		try {
			
			for (Friend friend : selectFriend) {
				if(friend.getAccept_user().equals(user.getUserName())) {
					friendNameList.add(friend.getSummit_user());
				}else {
					friendNameList.add(friend.getAccept_user());
				}
				
			}
			
			HashSet<String> hs = new HashSet<String>(friendNameList);
			
			friendNameList = new ArrayList<String>(hs);
			
			req.setAttribute("friendNameList", friendNameList);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
}
