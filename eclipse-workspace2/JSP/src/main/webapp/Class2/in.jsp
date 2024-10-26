<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원가입 폼</h2>
	<form action="ExeUpdate.jsp" method="post">
		ID : <input type="text" name="ID" required><br>
		PW : <input type="text" name="PW" required><br>
		NM : <input type="text" name="NM" required><br>
		JD : <input type="text" name="JD" required><br>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>