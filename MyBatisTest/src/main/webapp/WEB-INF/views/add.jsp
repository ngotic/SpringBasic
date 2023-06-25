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
	<h1>입력</h1>
	<form method="POST" action="/mybatis/addok.do">
		<table class="vertical">
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" required></td>
			</tr>
			<tr>
				<th>나이</th>
				<td><input type="text" name="age" required></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="address" required></td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<select name="gender">
						<option value='m'>남자
						<option value='f'>여자
					</select>
				</td>
			</tr>
		</table>
		<input type="submit" value="버튼">
	</form>
	

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>






