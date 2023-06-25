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
	input[name=email] {
		display: block;
		margin-bottom: 5px;
	}
</style>
</head>
<body>
	<!-- add.jsp -->
	<h1>주소록<small>등록하기</small></h1>
	
	<form method="POST" action="/simple/addok.do">
	<table class="vertical">
		<tr>
			<th>이름</th>
			<td><input type="text" name="name" required></td>
		</tr>
		<tr>
			<th>나이</th>
			<td><input type="number" name="age" min="0" max="150" required class="short"></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type="text" name="address" required class="full"></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>
				<input type="text" name="emailList">
				<input type="text" name="emailList">
				<input type="text" name="emailList">
			</td>
		</tr>
	</table>
	
	<div>
		<input type="button" value="돌아가기" onclick="location.href='/simple/list.do';">
		<input type="submit" value="등록하기"> 
	</div>
	</form>	
	

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>






