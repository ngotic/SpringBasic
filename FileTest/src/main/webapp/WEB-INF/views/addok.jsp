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
	<!-- addok.jsp -->
	<h1>결과</h1>
	<div class="message" title="txt">${txt}</div>
	<div class="message" title="file">${filename}
		<a href="/file/resources/files/${filename}" download>${filename}</a>
	</div>
	
	<div class="message" title="file">
		<a href="/file/download.do?filename=${filename}">${filename}</a>
	</div>	

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>






