<%@ page language="java" contentType="text/html; charset =UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
	<script type="text/javascript">
		function login(){
			location.href = "/comm/login.chain"
		}
		
		function getJsonList(){
			location.href = "/comm/getJsonList.chain"
		}
	</script>
</head>

<body>
	<h1>커멘트 게시판 입니다.</h1>
	<P>즐겁게 코딩합시다.</P>

<!-- 액션을 절대경로로 할 경우 -->
	<form action = "/comm/commList.chain" method ="get">
		<input type="submit" value="커멘트로 가기" />&nbsp;&nbsp;&nbsp;
		<c:if test="${id == null }">
		<input type="button" value="로그인" onclick="login()" /></c:if>
		<br><br> 
		<input type="button" value="JSON 형식으로 커맨트 보기" onclick = "getJsonList()"/>
		<br><br>
		<button>버튼2</button>
	</form>
	<div>
		<c:if test="${id!=null}">
			<%@include file="loginOK.jsp"%>
		</c:if>
	</div>
	
</body>
</html>
