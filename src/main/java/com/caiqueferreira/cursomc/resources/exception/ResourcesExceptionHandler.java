package com.caiqueferreira.cursomc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourcesExceptionHandler {
    @ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StantardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
	  StantardError err = new StantardError(HttpStatus.NOT_FOUND.value(),e.getMessage(), System.currentTimeMillis());
	  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
   }
   
}
