package com.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


// JSP Model2 > (발전) > Spring MVC.


// 서블릿 역할
public class Ex01Controller implements Controller{
	
	// 요청 메소드
	// doGet/doPost == handleRequest
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// RequestDispatcher > forward()
		// Model > 데이터 전송
		// View  > JSP
		ModelAndView mv = new ModelAndView();
		
		// mv.setViewName("/WEB-INF/views/ex01.jsp"); // 에러다.> 뷰리졸버 생략시 이거 쓰기
		mv.setViewName("ex01"); // 얘는 내부적으로 담고 있다. 
		
		
		// 비권장.
		request.setAttribute("name", "홍길동");
		
		return mv;
	}
	
}
