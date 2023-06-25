<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
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
	<!-- layout > member.jsp
	타일즈는 메인업무도 추출한다. -->
	<header>
		<h1>Tiles</h1>
		<tiles:insertAttribute name="main_menu"/>
		<tiles:insertAttribute name="admin_menu"/>	
	</header>	
	
	<tiles:insertAttribute name="content"/>	


<script>

</script>
</body>
</html>






