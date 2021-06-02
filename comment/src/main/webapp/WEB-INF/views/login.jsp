<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login.chain" method = "post">
		 <label for="id">I D: <input type = "text" name="id" id = "id" required = "required"></label><br>
		 <label for="pass">PASS: <input type = "text" name="pass" id = "pass" required = "required"></label>
		 <input type= "submit" value = "로그인">
		 <input type= "reset" value = "취소">
		 <input type= "button" value = "회원가입">
	</form>
</body>
</html>