package com.peter.myport.sns;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peter.myport.user.User;

@Service
public class SnsDAO {

	@Autowired
	private SqlSession ss;
	
	
	public void insertSns(Sns s, HttpServletRequest req) {
		
		String token = req.getParameter("token");
		System.out.println("token 값 "+ token);
		
		String successToken = (String) req.getSession().getAttribute("successToken");
		System.out.println("successToken 값 "+ successToken);
		
		s.setTitle(req.getParameter("title"));
		s.setContent(req.getParameter("content"));
		User u = (User) req.getSession().getAttribute("loginUser");
		s.setWriter(u.getUserName());
		
		if(token.equals(successToken)) {
			// 바꿔야함
			System.out.println("토큰 중복으로 인한 글쓰기 실패");
		}else {
			
			if(ss.getMapper(SnsMapper.class).insertSns(s) == 1) {
				System.out.println("글쓰기 성공");
				req.getSession().setAttribute("successToken", token);
			}
			
		}
		
	}
	
	public void selectSns(HttpServletRequest req) {
		List<Sns> listSns = ss.getMapper(SnsMapper.class).selectSns();
		req.setAttribute("listSns", listSns);
	}
	public void snsToken(HttpServletRequest req) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmmSSss");
		System.out.println(sdf.format(now));
		String token = sdf.format(now);
		req.setAttribute("token", token);
		
	}
}	
