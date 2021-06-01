<%@ page language="java" contentType="text/html; charset =UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>커멘트 게시판 입니다.</h1>
	<P>즐겁게 코딩합시다.</P>
<!-- 액션을 절대경로로 할 경우 -->
	<form action = "/comm/commList.chain" method ="get">
		<input type="submit" value="커멘트로 가기" /><br> 
		<input type="button" value="버튼" /><br>
		<button>버튼2</button>
	</form>
	
	
</body>
</html>
