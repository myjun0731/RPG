<%@page import="common.DBConnPool"%>
<%@page import="common.JDBConnect"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC</title>
</head>
<body>
	<h2>회원가입 상태</h2>

	<form action="Login.jsp">
		<%
			// DB에 연결
		DBConnPool pool = new DBConnPool();
		String id = request.getParameter("ID");
		String pass = request.getParameter("PW");
		String name = request.getParameter("NM");
		String joindate = request.getParameter("JD");
		// 쿼리문 생성
		String sql = "insert into userlist values (?, ?, ?, ?, sysdate)";
		PreparedStatement psmt = pool.con.prepareStatement(sql);
		psmt.setString(1, id);
		psmt.setString(2, pass);
		psmt.setString(3, name);
		psmt.setString(4, joindate);
		// 쿼리 수행
		int inResult = psmt.executeUpdate();
		out.println(inResult + "행이 입력되었습니다.!!!!!!!!!");

		// 연결 닫기
		pool.close();
		%>
		<input type="submit" value="로그인">
	</form>
</body>
</html>