package com.example.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class AspectConfig {
	
//	Logger logger = LoggerFactory.getLogger(getClass());	
//	
//	@Before(value = "execution(* com.example.controller.*.*(..))")
//	public void beforeAdvice(Joinpoint joinPoint)
//	{
//		logger.info("Inside before advice" );
//	}
	
}
