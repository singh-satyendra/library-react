package com.ibm.library.common.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.reactive.function.client.WebClientResponseException;

/**
 * This class could be used as a global exception handler, if any exception is thrown by the system then it can handle it 
 * with the help of below handlers.
 *  
 * @author 
 *
 */
@ControllerAdvice
public class GlobalExceptionAdvice extends ResponseEntityExceptionHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionAdvice.class);
	
	@ExceptionHandler(RuntimeException.class)
	public final ResponseEntity<?> handleRuntimeExceptions(RuntimeException e, WebRequest request) {
		LOGGER.info("handleRuntimeExceptions, inside."+e.getClass());
		ErrorResponseMessage oErrorDetails = new ErrorResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(), e.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(oErrorDetails, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(WebClientResponseException.class)
	public ResponseEntity<?> handleWebClientResponseException(WebClientResponseException e, WebRequest request) {
		ErrorResponseMessage oErrorDetails = new ErrorResponseMessage(e.getRawStatusCode(), e.getStatusCode().name(), e.getMessage(), request.getDescription(false));
		return ResponseEntity.status(e.getRawStatusCode()).body(oErrorDetails);
	}
}
