package com.home.education.mountains.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LogAspect {

	private static final Logger log = LoggerFactory.getLogger(LogAspect.class);
	
	@Before("execution(* com.home.education.mountains.service.impl.ReadWriteGenericServiceImpl.*(..))")
	public void logBefore(JoinPoint joinPoint){
		log.info(joinPoint.getSignature().getName()+"==================");
	} 
}
