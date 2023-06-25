<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>   

<!-- 

	스프링 시큐리티 > JSP 페이지 + 권한 적용 > 스프링 시큐리티 표현식  
	
 -->

<!--  header.jsp -->
<header>
		<h1>Spring Security</h1>
		<ul>
			<li><a href="/security/index.do">Index</a></li>
			
			<sec:authorize access="hasRole('ROLE_MEMBER')">
			<li><a href="/security/member.do">Member</a></li>
			</sec:authorize>
			
			<sec:authorize access="hasRole('ROLE_ADMIN')">
			<li><a href="/security/admin.do">Admin</a></li>
			</sec:authorize>
			
			<li class="divider"></li>
			
			<sec:authorize access="isAnonymous()">
				<li><a href="/security/customlogin.do">Login</a></li>
			</sec:authorize>
			<li><a href="/security/register.do">Register</a></li>
			
			<sec:authorize access="isAuthenticated()">
				<li><a href="/security/customlogout.do">Logout</a></li>
				<li class="divider"></li>
				<li><a href="/security/info.do">Info</a></li>
			</sec:authorize>
			
			
			
			
			
		</ul>
</header>






