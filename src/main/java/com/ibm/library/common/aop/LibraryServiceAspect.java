package com.ibm.library.common.aop;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @author 
 *
 */
@Aspect
@Configuration
public class LibraryServiceAspect implements LibraryServiceAspectInt {
	
	private final Logger logger = LoggerFactory.getLogger(LibraryServiceAspect.class);
	
	@Before(value = "execution(* com.ibm.library.rest.*.*(..))")
	public void before(JoinPoint joinPoint){
		logger.info("enter execution for {}", joinPoint);
	}
	
	
	/*
	 * @After(value = "execution(* com.ibm.library.rest.*.*(..))") public void
	 * after(JoinPoint joinPoint) { logger.info("after execution of {}", joinPoint);
	 * }
	 */
	
	@AfterReturning(value = "execution(* com.ibm.library.rest.*.*(..))", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		logger.info("exiting after successful execution of {} ", joinPoint, result);
	}
	
	@AfterThrowing(value = "execution(* com.ibm.library.rest.*.*(..))", throwing = "e")
	public void afterThrowing(JoinPoint joinPoint, Throwable e) {
		StringBuilder sb = new StringBuilder();
		sb.append(joinPoint.getSignature());
		sb.append(" : ");
		sb.append(Arrays.toString(joinPoint.getArgs()));
		sb.append(" - exiting with exception: ");
		sb.append(e.getMessage());
		
		logger.info(sb.toString());
	}
	
}

