package com.peter.myport.user;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peter.myport.friend.Friend;
import com.peter.myport.friend.FriendMapper;
import com.peter.myport.login.LoginDAO;

@Service
public class UserDAO {

	@Autowired
	private SqlSession ss;
	// 암호화를 위한
	@Autowired
	private LoginDAO lDAO;

	// 회원정보 수정
	public void updateInfo(User u, HttpServletRequest req) {
		// 파라미터 받기
		String password = req.getParameter("password");

		String sha_password = lDAO.SecuritySHA268(password);

		String address = req.getParameter("address");
		String phone = req.getParameter("phoneNumber");
		// 세션 받기
		User loginUser = (User) req.getSession().getAttribute("loginUser");

		// sql null 오류 방지================================
		if (sha_password == null || sha_password.equals("")) {
			sha_password = loginUser.getPassword();
		}
		if (address == null || password.equals("")) {
			address = loginUser.getAddress();
		}
		if (phone == null || password.equals("")) {
			phone = loginUser.getPhoneNumber();
		}

		System.out.println(phone);
		System.out.println(sha_password);
		System.out.println(address);
		// ======================================================

		u.setPassword(sha_password);
		u.setAddress(address);
		u.setPhoneNumber(phone);
		u.setUserName(loginUser.getUserName());
		// 업데이트
		if (ss.getMapper(UserMapper.class).updateUser(u) == 1) {
			// 다시 로그인해야함
			u.setName(loginUser.getName());
			u.setUserBirth(loginUser.getUserBirth());
			u.setEmail(loginUser.getEmail());
			req.getSession().setAttribute("loginUser", u);
			// 바꿔야함
			System.out.println("변경 성공");
		}

		System.out.println(loginUser.getUserName());

	}

	// 탈퇴
	public void deleteUser(User u, HttpServletRequest req) {
		// 그냥 세션으로 삭제해도됨
		u.setUserName(req.getParameter("username"));
		if (ss.getMapper(UserMapper.class).deleteUser(u) == 1) {
			// 바꿔야함
			req.getSession().setAttribute("loginUser", null);
			System.out.println("탈퇴 성공");
		}
	}

	// 친구추천 리스트
	public void selectAllUser(User u, Friend f, HttpServletRequest req) {
		u = (User) req.getSession().getAttribute("loginUser");
		f.setAccept_user(u.getUserName());
		f.setStatus("accept");
		f.setSummit_user(u.getUserName());
		List<Friend> friendUser = ss.getMapper(FriendMapper.class).selectFriend(f);
		List<User> selectAllUser = ss.getMapper(UserMapper.class).selectAllUser();

		ArrayList<String> userList = new ArrayList<String>();

		for (Friend friend : friendUser) {
			if (friend.getAccept_user().contentEquals(u.getUserName())) {
				userList.add(friend.getSummit_user());
			} else {
				userList.add(friend.getAccept_user());
			}
		}

		userList.add(u.getUserName());

		HashSet<String> hs = new HashSet<String>(userList);

		userList = new ArrayList<String>(hs);

		ArrayList<String> users = new ArrayList<String>();

		for (User user : selectAllUser) {
			for (String str : userList) {

				try {
					if (user.getUserName().equals(str)) {
						System.out.println("중복");
						user.setUserName(null);
					} else {
						
					}
					
				} catch (Exception e) {
					// TODO: handle exception
					
				}
				
			}
			users.add(user.getUserName());
			
		}

		req.setAttribute("selectAllUser", users);
	}

	// 유저 프로필
	public void selectUserDetail(User u, HttpServletRequest req) {
		u.setUserName(req.getParameter("user"));
		User selectUserDetail = ss.getMapper(UserMapper.class).selectUserDetail(u);

		req.setAttribute("selectUserDetail", selectUserDetail);
	}

}
