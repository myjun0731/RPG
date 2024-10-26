<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>
		<%=session.getAttribute("UserName")%>
		님 로그아웃 완료
	</h2>
	<%
		session.removeAttribute("UserId");
	session.removeAttribute("UserName");

	session.invalidate();
	%>
	<a href="Login.jsp">[로그인 폼으로 가기]</a>
</body>
</html>