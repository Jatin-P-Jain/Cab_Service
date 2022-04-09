package com.personal.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.aspectj.lang.annotation.AfterThrowing;

public class LoggingAspect {
	
	 private static final Log LOGGER = LogFactory.getLog(ExceptionControllerAdvice.class);


	@AfterThrowing(pointcut = "execution(* com.infy.service.*Impl.*(..))", throwing = "exception")
	public void logServiceException(Exception exception)
			throws Exception {
		LOGGER.error(exception.getMessage(), exception);	
	}
}
