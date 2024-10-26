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
	String id = request.getParameter("user_id");
	String pwd = request.getParameter("user_pwd");
	String user_id = (String) session.getAttribute("user_id");
	String user_pwd = (String) session.getAttribute("user_pwd");
	if (id.equalsIgnoreCase(user_id) && pwd.equalsIgnoreCase(user_pwd)) {
		response.sendRedirect("Welcome.jsp");
	} else {
		response.sendRedirect("fail.jsp");
	}
	%>
</body>
</html>