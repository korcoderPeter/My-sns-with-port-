<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/myport/snsWrite" >
<input  name ="token" value="${token }"> 
title:
<input name="title">
comment:
<textarea rows="1" name="content"></textarea>
<button>글작성</button>
</form>

</body>
</html>