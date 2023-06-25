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
	<!-- template.jsp -->
	<%@ include file="/WEB-INF/views/inc/header.jsp" %>
	
	<h2>custLogin page</h2>
	<div class="message">${error}</div>
	<div class="message">${logout}</div>
	<form method="POST" action="/security/login">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="username" required></td>
			</tr>
			<tr>
				<td>암호</td>
				<td><input type="password" name="password" required></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="checkbox" name="remember-me">
					자동 로그인
				</td>
			</tr>
		</table>
		<div>
			<button class="in">로그인</button>
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>






