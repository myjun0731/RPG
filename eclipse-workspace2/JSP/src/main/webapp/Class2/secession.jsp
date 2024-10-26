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

	<form action="Logout.jsp">
		<%
		// DB에 연결
		DBConnPool pool = new DBConnPool();
		String id = session.getAttribute("UserId").toString();
		// 쿼리문 생성
		String sql = "delete from userlist where id = ?";
		PreparedStatement psmt = pool.con.prepareStatement(sql);
		System.out.println(id);
		psmt.setString(1, id);
		// 쿼리 수행
		int inResult = psmt.executeUpdate();

		// 연결 닫기
		pool.close();
		out.println(inResult + "회원 탈퇴 완료!");
		System.out.println(session.getAttribute("UserId"));
		%>
		<input type="submit" value="로그인 폼">
	</form>


</body>
</html>
