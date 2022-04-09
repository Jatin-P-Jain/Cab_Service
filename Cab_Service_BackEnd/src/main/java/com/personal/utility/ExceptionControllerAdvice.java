package com.personal.utility;

import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.personal.exception.CabException;


@RestControllerAdvice
public class ExceptionControllerAdvice {
	
	 private static final Log LOGGER = LogFactory.getLog(ExceptionControllerAdvice.class);

	@Autowired
	private Environment environment;
	
	@ExceptionHandler(CabException.class)
	public ResponseEntity<ErrorInfo> exceptionHandler(CabException ex) {
		 ErrorInfo error = new ErrorInfo();
	     error.setErrorCode(HttpStatus.BAD_REQUEST.value());
	     error.setErrorMessage(environment.getProperty(ex.getMessage()));
	     return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * Exception handler for general exception "Exception".
	 * 
	 * @param exception
	 * @return the error information with error code and error message
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> generalExceptionHandler(Exception ex) {

		LOGGER.error(ex.getMessage(), ex);

		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorInfo.setErrorMessage(environment.getProperty("General.EXCEPTION_MESSAGE"));

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorInfo);
	}
	
	
	

	/**
	 * Exception handler for MethodArgumentNotValidException and
	 * ConstraintViolationException.
	 *
	 * @param exception
	 * @return the error information with error code and error message
	 */
	@ExceptionHandler({ MethodArgumentNotValidException.class, ConstraintViolationException.class })
	public ResponseEntity<ErrorInfo> exceptionHandler2(Exception ex) {

		LOGGER.error(ex.getMessage(), ex);

		String errorMsg;

		if (ex instanceof MethodArgumentNotValidException) {
			MethodArgumentNotValidException manve = (MethodArgumentNotValidException) ex;
			errorMsg = manve.getBindingResult().getAllErrors().stream().map(x -> x.getDefaultMessage())
					.collect(Collectors.joining(", "));
		} else {
			ConstraintViolationException cve = (ConstraintViolationException) ex;

			errorMsg = cve.getConstraintViolations().stream().map(x -> x.getMessage())
					.collect(Collectors.joining(", "));
		}

		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorInfo.setErrorMessage(errorMsg);

		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}
	


}
