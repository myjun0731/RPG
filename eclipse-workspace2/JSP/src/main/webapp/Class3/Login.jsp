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
<!--
회원가입 session 버전 과제
1. 회원가입폼 페이지
아이디, 비밀번호, 이메일, 이름, 생년월일, 연락처, 성별, 내국인/외국인,
좋아하는 취미 공부/오락/운동/노래

2. 회원가입완료 페이지
회원가입이완료되었습니다. 출력
하이퍼링크 - 로그인하러가기

3. 로그인폼 페이지
로그인할 id와 pw는 1번 회원가입폼에서 입력한 id, pw를 비교하여 로그인 성공/실패 확인

4. 로그인성공 페이지
로그인 성공할 시 회원가입 시 입력했던 모든 데이터들 출력과 더불어 로그인성공 메세지 출력

5. 로그인 실패 페이지
로그인 실패할 시 로그인 실패 메세지 출력 후, 
하이퍼링크 - 로그인하러가기
-->

<h2>회원가입 페이지</h2>
	<form action="./Main.jsp" method="post">
		아이디 : <input type="text" name="id"> <br />
		패스워드 : <input type="text" name="pwd"> <br />
		이메일 : <input type="text" name="email"> <br />
		이름 : <input type="text" name="name"> <br />
		생년월일 : <input type="text" name="birthday"> <br />
		연락처 : <input type="text" name="contact"> <br />
		성별 : <input type="radio" name="gender" value="남자" />남자 <input type="radio"
			name="gender" value="여자" checked="checked" />여자<br />
		국적 : <input type="radio" name="nationality" value="내국인" />내국인 <input type="radio"
			name="nationality" value="외국인" checked="checked" />외국인<br />
			
		관심사항 : <input type="checkbox" name="favo" value="공부" />공부
		<input type="checkbox" name="favo" value="오락" checked="checked" />오락
		<input type="checkbox" name="favo" value="운동" />운동
		<input type="checkbox" name="favo" value="노래" />노래
		<input type="submit" value="회원가입">
	</form>

</body>
</html>