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
	
	<h2>Custom Logout Page</h2>
	<!-- 이걸 POST라고 해도 따로 안만들어도 된다. 왜냐면 스프링 시큐리티가 알아서 하니까 그렇다.  -->
	<form method="POST" action="/security/customlogout.do">
		<div>
			<button class="out">로그아웃</button>
		</div>
		<!-- post처리니까 이렇 넣음 -->
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">		
	</form>	

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>






