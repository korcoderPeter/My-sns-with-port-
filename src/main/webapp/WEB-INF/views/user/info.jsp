<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원정보</h1>
<form action="/myport/updateInfo.com" method="post">
${loginUser.userName  } <br>
${loginUser.password  } <br>
비밀번호 변경 : <input name="password"><br>
${loginUser.name  } <br>
${loginUser.userBirth  } <br>
${loginUser.address  } <br>
주소 변경 : <input name="address"><br>
${loginUser.email  } <br>
${loginUser.phoneNumber  } <br>
전화번호 변경 : <input name="phoneNumber"><br>
<button>회원정보수정</button> 
</form>
<form action="/myport/deleteUser.com" method="post">
<input value="${loginUser.userName }" name="username">

<button>탈퇴</button>
</form>


</body>
</html>