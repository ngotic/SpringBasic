<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Code</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<style>

</style>
</head>
<body>
	<!-- add.jsp -->
	<h1>Code <small>추가하기</small></h1>
	<form method='POST' action='/addok.do'>
	
	<table class='vertical'>
		<tr>
			<th>제목</th>
			<td><input type="text" name="subject" required class="full"></td>
		</tr>
		<tr>
			<th>코드</th>
			<td><textarea name="code" required class="full"></textarea></td>
		</tr>
		<tr>
			<th>언어</th>
			<td>
				<select name="language">
					<option value="java">Java</option>
					<option value="sql">SQL</option>
					<option value="html">HTML</option>
				</select>
			</td>
		</tr>
	</table>
	<div>
		<button type="submit" class="add">추가하기</button>
		<button type="button" class="back" onclick="location.href='/list.do'" >돌아가기</button> 
	</div>
	</form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>






