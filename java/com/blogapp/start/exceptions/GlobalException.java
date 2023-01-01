package com.blogapp.start.exceptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blogapp.start.Dto.ApiResponse;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler({ResourceNotFoundException.class})
	public ResponseEntity<ApiResponse> m1(){
		ApiResponse ai=new ApiResponse();
		ai.setProblem("resorceserror");
		ai.setError("please entervalid  resource");
		return new ResponseEntity<ApiResponse>(ai,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler({MethodArgumentNotValidException.class})
	public ResponseEntity<Map<String, String>> m2(MethodArgumentNotValidException ex){
		Map<String, String> map=new HashMap<>();
		List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
		allErrors.forEach((error)->{
			       String fieldname= ((FieldError)error).getField();
			       String defaultMessage = error.getDefaultMessage();
			       map.put(fieldname, defaultMessage);
			       });
			       
			       
			return new ResponseEntity<Map<String, String>>(map,HttpStatus.BAD_REQUEST);
			
			
		};
		
		
	 
		
	}
	
	


