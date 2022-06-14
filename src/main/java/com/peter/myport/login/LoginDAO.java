package com.peter.myport.login;

import java.security.MessageDigest;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peter.myport.user.User;
import com.peter.myport.user.UserMapper;

@Service
public class LoginDAO {

	@Autowired
	private SqlSession ss;

	// 가입
	public void join(HttpServletRequest req) {
		String sha_password = req.getParameter("password");

		// 암호화
		sha_password = SecuritySHA268(sha_password);
		if (sha_password != null) {
			System.out.println("암호화 성공");

			User u = new User(req.getParameter("username"), sha_password, req.getParameter("name"),
					req.getParameter("userbirth"), req.getParameter("address"), req.getParameter("email"),
					req.getParameter("phonenumber"));
			if (ss.getMapper(UserMapper.class).insertUser(u) == 1) {
				System.out.println("가입 성공");
			}

		} else {
			System.out.println("암호화 실패");
		}
	}

	// 로그인
	public void login(User u, HttpServletRequest req) {

		u.setUserName(req.getParameter("username"));

		User requestUser = ss.getMapper(UserMapper.class).selectLogin(u);

		String sha_password = req.getParameter("password");

		// 암호화
		sha_password = SecuritySHA268(sha_password);

		try {
			if (requestUser != null) {
				if (requestUser.getPassword().equals(sha_password)) {
					req.getSession().setAttribute("loginUser", requestUser);
					req.getSession().setMaxInactiveInterval(10 * 60);
				} else {
					req.setAttribute("r", "비밀번호 오류");
				}
			} else {
				req.setAttribute("r", "해당 아이디는 존재하지 않습니다");
			}

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "서버 문제로 인한 로그인 실패");
		}

	}

	// logout
	public void logout(HttpServletRequest req) {
		req.getSession().setAttribute("loginUser", null);
	}

	// 비밀번호 암호화
	public String SecuritySHA268(String str) {
		String sha = "";
		try {
			MessageDigest sh = MessageDigest.getInstance("SHA-256");
			sh.update(str.getBytes());
			byte byteData[] = sh.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));

			}
			sha = sb.toString();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("암호화 실패");
			sha = null;
		}

		return sha;
	}

}
