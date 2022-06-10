<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>sns</h1>
<c:choose>
<c:when test="${ loginUser == null}">
<a href="/myport/loginPage.com">로그인</a>
</c:when>
<c:otherwise>
${loginUser.userName}님 환영합니다  <a href="/myport/logout.com">로그아웃</a> <a href="/myport/info.com">회원정보</a>
</c:otherwise>
</c:choose>

<br>
<br>

<a href="/myport/snsWritePage">글쓰기</a> <br>
<c:forEach var="ls" items="${listSns }"> ${ls.sns_no } / ${ls.title } / ${ls.content } <br> </c:forEach>

</body>
</html>