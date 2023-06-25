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
	<!-- rest.jsp -->
	<h1>Rest</h1>
	
	
	
	
	<table id="list">
		<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>날짜</th>
			<th>아이디</th>
		</tr>
		</thead>
		<tbody>
		 	
		</tbody>
	</table>
	<!--  SSR의 랜더링 방식과 CSR의 랜더링 방식의 차이 -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>
	$.ajax({
		type: 'GET',
		url : 'http://localhost:8091/rest/board',
		dataType : 'JSON',
		success: function(result) {
			
			let temp='';
			
			$(result).each((index, item) => {
				
				temp += `
				<tr>
					<td>\${item.seq}</td>
					<td>\${item.subject}</td>
					<td>\${item.content}</td>
					<td>\${item.id}</td>
				</tr>
				`;				
			}); // each
			
			$('#list tbody').html(temp);
		},
		error : (a, b, c) => console.log(a, b, c)
	});
</script>
</body>
</html>






