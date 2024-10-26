<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%request.setCharacterEncoding("UTF-8"); %>

	<form action="ExeUpdate.jsp" method="post">
		id : <input type="text" name="id" required><br>
		pass : <input type="text" name="pass" required><br>
		name : <input type="text" name="name" required><br>
		<input type="submit" value="제출">
	</form>
</body>
</html>