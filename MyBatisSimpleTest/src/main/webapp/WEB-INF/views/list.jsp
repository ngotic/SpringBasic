<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<style>

</style>
</head>
<body>
	<!-- list.jsp -->
	<h1>주소록<small>목록보기</small></h1>
	
	<table>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>나이</th>
			<th>주소</th>
			<th>이메일</th>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.seq}</td>
			<td>${dto.name}</td>
			<td>${dto.age}</td>
			<td>${dto.address}</td>
			<td>
				<c:forEach items="${dto.email}" var="edto">
					<div>${edto.email}</div>
				</c:forEach>
			</td>
		</tr>
		</c:forEach>
	</table>
	<div>
		<input type="button" value="등록하기" class="add" onclick="location.href='/simple/add.do';">
	</div>
	

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>






