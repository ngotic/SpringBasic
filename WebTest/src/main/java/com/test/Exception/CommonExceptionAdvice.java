package com.test.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

//얘도 컴포넌트의 일정이다. 이 패키지가 ★★'스캔'의 대상이 되어야 한다.
@ControllerAdvice  
@Log4j
public class CommonExceptionAdvice {
	//ArithmeticException 산술이면 이거
	// , Model을 만들어서 데이터를 같이 넘길 수 있다.  
	@ExceptionHandler(Exception.class)
	public String except(Exception e, Model model) {
		log.error("예외 발생");
		model.addAttribute("code","A001");
		model.addAttribute("e", e);
		return "error";
	}
	
	// 이 두개의 조합으로 404에러가 났을 때 처리가 가능하다.
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String notfound() {		
		return "notfound";
	}
}
