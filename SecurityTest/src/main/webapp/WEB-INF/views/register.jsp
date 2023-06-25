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
	<!-- register.jsp -->
	<!-- get요청이 아닌 나머지 POST요청 -->
	<!-- get빼고 나머지 요청은 csrf토큰을 넘겨야 한다. -->
	<form method="POST" action="/security/registerok.do">
	
	<table class="vertical">
		<tr>
			<th>아이디</th>
			<td><input type="text" name="userid" required></td>
		</tr>
		<tr>
			<th>암호</th>
			<td><input type="password" name="userpw" required></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="username" required></td>
		</tr>
		<tr>
			<th>권한</th>
			<td>
				<select name="auth">
					<option value="1">일반회원</option>
					<option value="2">관리자</option>
				</select>
			</td>
		</tr>
	</table>
	<div>
		<input type="submit" value="등록하기">
	</div>
	<!-- csrf 토큰 -->
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>
	

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>






