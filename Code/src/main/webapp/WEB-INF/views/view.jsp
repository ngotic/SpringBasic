<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Code</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<link rel="stylesheet" href="/resources/highlight/styles/dark.min.css">
<style>

#code{
	margin: 1rem;
	border : 1px solid var(--border-color);
}

#code * {
	font-family: consolas;
}

</style>
</head>
<body>
	<!-- list.jsp -->
	<h1>Code <small>추가하기</small></h1>
	
	
	<table>
		<tr>
			<th>번호</th>
			<td>${dto.seq}</td>
			<td>날짜</tD>
			<td>${dto.regdate}</td>
		</tr>
		<tr>
			<td colspan="4">${dto.subject}</td>		
		</tr>
	</table>
	
	<!-- 우리가 가진 코드를 있는 그대로 처리한다.  -->
	<pre id="code">
		<code class="language-${dto.language}">
		<c:out value="${dto.code}"/></code>
	</pre>
	
	<div>
		<button type="button" class="back" onclick="location.href='/list.do';">
			돌아가기
		</button>
	</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="/resources/highlight/highlight.min.js"></script>

<script>
hljs.highlightAll();
</script>
</body>
</html>






