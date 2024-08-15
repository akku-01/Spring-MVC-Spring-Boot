package springmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

//Centralized Exception Handler

@ControllerAdvice
public class MyExceptionHandler {

//	Handling specific exception in spring mvc
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR) //Sending Status code
	@ExceptionHandler(value = NullPointerException.class)
	public String exceptionHandlerNull() {
		return "nullPage";
	}
	
//	General exception handling in spring mvc
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR) //Sending Status code
	@ExceptionHandler(value = Exception.class)
	public String exceptionHandlerGeneral() {
		return "nullPage";
	}
}
