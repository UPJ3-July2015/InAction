package net.lermex.inaction.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogingAspect {
	
	@Before("execution(* net.lermex..*.*(..))")
	public void justMethodLog(JoinPoint joinPoint){
		
		System.out.println("This method activated - " + joinPoint.getSignature().getName() );
		
	}

}
