<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
	<!-- log.jsp -->
<%-- 	<header>
		<h1>Tiles</h1>
		<%@ include file="/WEB-INF/views/inc/main_menu.jsp" %>
		<%@ include file="/WEB-INF/views/inc/admin_menu.jsp" %>
	</header>	 --%>
	
	<h1>관리자<small>로그</small></h1>
	
	<pre style="padding:1rem; white-spaec:pre-wrap;">
	INFO : org.springframework.beans.factory.xml.XmlBeanDefinitionReader - Loading XML bean definitions from ServletContext resource [/WEB-INF/spring/appServlet/servlet-context.xml]
INFO : org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor - JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
INFO : org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping - Mapped "{[/],methods=[GET]}" onto public java.lang.String com.test.nontiles.HomeController.home(java.util.Locale,org.springframework.ui.Model)
INFO : org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping - Mapped "{[/log.do],methods=[GET]}" onto public java.lang.String com.test.controller.AdminController.log()
INFO : org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping - Mapped "{[/setting.do],methods=[GET]}" onto public java.lang.String com.test.controller.AdminController.setting()
	</pre>
	





