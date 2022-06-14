package com.peter.myport.sns;

import java.io.File;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;
import com.peter.myport.friend.Friend;
import com.peter.myport.friend.FriendDAO;
import com.peter.myport.user.User;
import com.peter.myport.user.UserDAO;

@Controller
public class SnsController {
	
	@Autowired
	private SnsDAO sDAO;
	
	@Autowired
	private UserDAO uDAO;
	
	@Autowired
	private FriendDAO fDAO;

	@RequestMapping(value="/snsWritePage", method = RequestMethod.GET)
	public String snsWritePage(HttpServletRequest req) {
		// 토큰
		sDAO.snsToken(req);
		
		return "/sns/snsWritePage";
	}
	@RequestMapping(value="/snsWrite", method = RequestMethod.GET)
	public String snsWrite(Friend f, Sns s, HttpServletRequest req, User u) {
		sDAO.countAllMsg();
		sDAO.insertSns(s, req);
		sDAO.selectSns(1, req);
		if(req.getSession().getAttribute("loginUser") != null) {
			uDAO.selectAllUser(u, f, req);
			fDAO.selectFriend(f,req);
			fDAO.selectSummitedList(f, req);			
		}
		return "index";
	}
	@RequestMapping(value="/snsDetail", method = RequestMethod.GET)
	public String snsDetail(Sns s, HttpServletRequest req) {
		
		sDAO.selectSnsById(s, req);
		
		return "sns/snsDetail";
	}
	
	
	// 친구 프로필 
	@RequestMapping(value="/snsFriendPage", method = RequestMethod.GET)
	public String snsFriendPage(User u, HttpServletRequest req) {
		uDAO.selectUserDetail(u, req);
		return "sns/snsFriendPage";
	}
	
	@RequestMapping(value="/moveSnsPage", method = RequestMethod.GET)
	public String moveSnsPage(Friend f, HttpServletRequest req, User u) {
		sDAO.countAllMsg();
		int page = Integer.parseInt(req.getParameter("page"));
		sDAO.selectSns(page, req);
		if(req.getSession().getAttribute("loginUser") != null) {
			uDAO.selectAllUser(u, f, req);
			fDAO.selectFriend(f,req);
			fDAO.selectSummitedList(f, req);			
		}
		return "index";
	}
	
	// 미완성
	@RequestMapping(value="/uploadSummbernote.com", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String uploadSummbernote(@RequestParam("file") MultipartFile multipartfile, HttpServletRequest req) {
		
		System.out.println("일단 실행됨");
		
		JsonObject jsonobject = new JsonObject();
		
		// string fileroot = "외부경로" // 외부경로 저장 을 희망할때
		String fileRoot ="C:/upload";
		// 내부경로 저장
		// String contextRoot = new HttpServletRequestWrapper(req).getRealPath("/");
		// String fileRoot = contextRoot + "\\src\\main\\webapp\\resources\\fileUpload\\";
		
		// 오리지날 파일명
		String originalFileName = multipartfile.getOriginalFilename(); 
		// 확장자
		String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
		
		String savedFileName = UUID.randomUUID() + extension;
		
		File targetFile = new File( fileRoot  + "/"+ savedFileName);
		
		try {
			InputStream fileStream = multipartfile.getInputStream();
			
			// 파일저장
			FileUtils.copyInputStreamToFile(fileStream, targetFile);
			
			// 저장할 내부 폴더명
			jsonobject.addProperty("url", fileRoot + "/" + savedFileName);
			jsonobject.addProperty("responseCode", "success");
			
			System.out.println("성공");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("실패");
			FileUtils.deleteQuietly(targetFile); // 저장된 파일 삭제
			jsonobject.addProperty("repsonseCode", "error");
			
			e.printStackTrace();
		}
		String a = jsonobject.toString();
		return a;
	}
	
}

