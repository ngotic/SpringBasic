<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- ex05ok.jsp -->
	<h1>결과</h1>
	
	<div class="message" title="데이터">
		${data}
	</div>
	
	<div class="message" title="DTO">
		<div>${dto.name}  </div>
		<div>${dto.age}  </div>
		<div>${dto.address}  </div>
	</div>
	
	<h1>다중 데이터 전송</h1>
	
	<h1>결과</h1>
	
	<div class="list">
		<c:forEach items="${cb}" var="item">
			<div>${item}</div>
		</c:forEach>
	</div>
	
</body>
</html>