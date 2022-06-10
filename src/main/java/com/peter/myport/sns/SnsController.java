package com.peter.myport.sns;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SnsController {
	
	@Autowired
	private SnsDAO sDAO;

	@RequestMapping(value="/snsWritePage", method = RequestMethod.GET)
	public String snsWritePage(HttpServletRequest req) {
		// 토큰
		sDAO.snsToken(req);
		
		return "/sns/snsWritePage";
	}
	@RequestMapping(value="/snsWrite", method = RequestMethod.GET)
	public String snsWrite(Sns s, HttpServletRequest req) {
		sDAO.insertSns(s, req);
		sDAO.selectSns(req);
		return "index";
	}
	
	
}
