<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	session.setAttribute("user_id", request.getParameter("id"));
	session.setAttribute("user_pwd", request.getParameter("pwd"));
	session.setAttribute("user_email", request.getParameter("email"));
	session.setAttribute("user_name", request.getParameter("name"));
	session.setAttribute("user_birthday", request.getParameter("birthday"));
	session.setAttribute("user_contact", request.getParameter("contact"));
	session.setAttribute("user_gender", request.getParameter("gender"));
	session.setAttribute("user_nationality", request.getParameter("nationality"));
	session.setAttribute("user_favo", request.getParameter("favo"));
	%>
	<h2>회원가입 성공</h2>
	<a href="Location.jsp">로그인 페이지로 이동</a>
</body>
</html>