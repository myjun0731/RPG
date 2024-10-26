<%@page import="membership.MemberDTO"%>
<%@page import="membership.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String userId = request.getParameter("user_id");
String userPwd = request.getParameter("user_pw");

String oracleDriver = application.getInitParameter("OracleDriver");
String oracleURL = application.getInitParameter("OracleURL");
String oracleId = application.getInitParameter("OracleId");
String oraclePwd = application.getInitParameter("OraclePwd");

MemberDAO dao = new MemberDAO(oracleDriver, oracleURL, oracleId, oraclePwd);
MemberDTO memberDTO = dao.getMemberDTO(userId, userPwd);

if (memberDTO.getId() != null) {

	session.setAttribute("userId", memberDTO.getId());
	session.setAttribute("userName", memberDTO.getName());
	response.sendRedirect("LoginForm.jsp");
} else {
	request.setAttribute("LoginErrMsg", "로그인 오류");
	request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
}
%>