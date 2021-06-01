<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function CommWrite(){
		location.href = "/comm/write.chain"
	}
</script>
</head>
<body>
<center>
	<div><input type = "button" value = "커멘트 쓰기" onclick="CommWrite()"/></div>
	<br>
	<div>
 		<table border ="1">
 			<thead>
 				<tr>
	 				<th>commentNum</th>
	 				<th>id</th>
	 				<th>content</th>
	 				<th>commentDate</th>
 				</tr>
 			</thead>
 			<tbody>
				<c:forEach var="item" items="${commList}">
					<tr>
						<td>commentNum: ${item.commentNum}</td>
						<td>id: ${item.id}</td>
						<td>content: ${item.content}</td>
						<td>commentDate: ${item.commentDate}</td>
					</tr>
				</c:forEach> 
			</tbody>
		</table>
	</div>
</center>	
	
</body>
</html>