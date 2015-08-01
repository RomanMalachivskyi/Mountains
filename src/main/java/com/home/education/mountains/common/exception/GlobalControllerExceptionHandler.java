package com.home.education.mountains.common.exception;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);
	
	@ExceptionHandler({LocationValidationFailedException.class})
	public ResponseEntity<Object> handleLocationValidation(LocationValidationFailedException ex){
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler({ConstraintViolationException.class})
	public ResponseEntity<Object> handleConstrainValidation(ConstraintViolationException ex){
		log.error(ex.getMessage(), ex);
		StringBuilder result = new StringBuilder();
		ex.getConstraintViolations().forEach(d-> result.append(d.getMessage()));
		return new ResponseEntity<>(result, HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler({DataIntegrityViolationException.class})
	public ResponseEntity<Object> handleSqlExceptionHelper(DataIntegrityViolationException ex){
		log.error(ex.getMessage());
		return new ResponseEntity<>(ex.getMostSpecificCause().getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler({ LocationDoesNotExistsException.class })
	public ResponseEntity<Object> handleLocationDoesNotExists(LocationDoesNotExistsException ex) {
		log.error(ex.getMessage());
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({ RuntimeException.class })
	public ResponseEntity<Object> handleRuntimeException(RuntimeException ex) {
		log.error("Handling unexpected runtime exception: " + ex.getMessage(), ex);
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
