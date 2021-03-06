package com.caiqueferreira.cursomc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.caiqueferreira.cursomc.service.exceptions.DataIntegrityException;
import com.caiqueferreira.cursomc.service.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourcesExceptionHandler {
    
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StantardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
	 
    	StantardError err = new StantardError(HttpStatus.NOT_FOUND.value(),e.getMessage(), System.currentTimeMillis());
	  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
   }
   
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StantardError> dataIntegrity(ObjectNotFoundException e, HttpServletRequest request) {
	 
      StantardError err = new StantardError(HttpStatus.BAD_REQUEST.value(),e.getMessage(), System.currentTimeMillis());
	  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
   }
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StantardError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
	  
      ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(),"Erro de validação", System.currentTimeMillis());
      for (FieldError x : e.getBindingResult().getFieldErrors()) {
    	  err.addError(x.getField(),x.getDefaultMessage());
      }
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
   }
}
