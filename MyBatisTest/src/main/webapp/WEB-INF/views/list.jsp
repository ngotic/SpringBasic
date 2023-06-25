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
	<!--  -->
	
	<h1>결과</h1>
	<div class="message" title="삭제">
		${result}
	</div>
	
	<div class="message" title="count">
		${count}
	</div>
	
	<div class="message" title="dto">
		<div>${dto.seq}</div>
		<div>${dto.name}</div>
		<div>${dto.age}</div>
		<div>${dto.address}</div>
		<div>${dto.gender}</div>
	</div>
	
	<div class="list">
		<c:forEach items="${names}" var="name">
			<div>${name}</div>
		</c:forEach>
	</div>

	<table>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>나이</th>
			<th>주소</th>
			<th>성별</th>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.seq}</td>
			<td>${dto.name}</td>
			<td>${dto.age}</td>
			<td>${dto.address}</td>
			<td>${dto.gender}</td>
		</tr>
		</c:forEach>
	</table>
	
	<div class="list">
		<c:forEach items="${elist}" var="name">
		<div>${name}</div>
		</c:forEach>
	</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>






