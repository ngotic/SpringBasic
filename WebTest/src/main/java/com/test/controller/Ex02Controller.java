package com.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.test.persistence.SpringDAO;

public class Ex02Controller implements Controller{
	
	private SpringDAO dao; 
	
	public Ex02Controller(SpringDAO dao) {
		this.dao = dao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 의존 객체 > 의존 주입
		// SpringDAO dao = new SpringDAOImpl();
		
		int count = dao.getCount();
		
		ModelAndView mv = new ModelAndView("ex02");
		
		mv.addObject("count", count);
		
		return mv; // 반드시 model and view를 리턴해야 한다. 
	}

}
