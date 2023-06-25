<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>

</style>
</head>
<body>
	<!-- index.jsp -->
	<header>
		<h1>Tiles</h1>
		<%@ include file="/WEB-INF/views/inc/main_menu.jsp" %>
		<%@ include file="/WEB-INF/views/inc/member_menu.jsp" %>
	</header>	
	
	<h1>회원<small>회원정보</small></h1>
	
	<div class="message" tile="홍길동">
		일반회원입니다.
	</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>






