<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>로그인 성공</h2>
		아이디 : <%=(String) session.getAttribute("user_id") %> <br>
		아이디 : <%=(String) session.getAttribute("user_pwd") %> <br>
		이메일 : <%=(String) session.getAttribute("user_email") %><br>
		이름 : <%=(String) session.getAttribute("user_name") %><br>
		생년월일 : <%=(String) session.getAttribute("user_birthday") %><br>
		연락처 : <%=(String) session.getAttribute("user_contact") %><br>
		성별 : <%=(String) session.getAttribute("user_gender") %><br>
		국적 : <%=(String) session.getAttribute("user_nationality") %><br>
		관심사항 : <%=(String) session.getAttribute("user_favo") %><br>
</body>
</html>