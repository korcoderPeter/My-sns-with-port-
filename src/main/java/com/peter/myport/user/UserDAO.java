package com.peter.myport.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDAO {

	@Autowired
	private SqlSession ss;
	// 회원정보 수정
	public void updateInfo(User u, HttpServletRequest req) {
		// 파라미터 받기
		String password = req.getParameter("password");
		String address = req.getParameter("address");
		String phone = req.getParameter("phoneNumber");
		// 세션 받기
		User loginUser = (User) req.getSession().getAttribute("loginUser");
		// sql null 오류 방지
		if(password == null ) {
			password = loginUser.getPassword(); 
		}
		if(address == null) {
			address = loginUser.getAddress(); 
		}
		if(phone == null) {
			phone = loginUser.getPhoneNumber(); 
		}
		System.out.println(phone);
		System.out.println(password);
		System.out.println(address);
		
		u.setPassword(password);
		u.setAddress(address);
		u.setPhoneNumber(phone);
		u.setUserName(loginUser.getUserName());
		// 업데이트
		if(ss.getMapper(UserMapper.class).updateUser(u) == 1) {
			// 바꿔야함
			System.out.println("변경 성공");
		}
		
		
		System.out.println(loginUser.getUserName());
		
	}
	// 탈퇴
	public void  deleteUser(User u, HttpServletRequest req) {
		// 그냥 세션으로 삭제해도됨 
		u.setUserName(req.getParameter("username"));
		if(ss.getMapper(UserMapper.class).deleteUser(u)== 1) {
			// 바꿔야함 
			req.getSession().setAttribute("loginUser", null);
			System.out.println("탈퇴 성공");
		}
	}
	
}
