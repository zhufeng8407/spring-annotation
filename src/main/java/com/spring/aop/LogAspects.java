package com.spring.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAspects {
	
	@Pointcut("execution(public int com.spring.aop.MathCalculator.*(..))")
	public void pointCut() {
	}

	@Before("pointCut()")
	public void logStart(JoinPoint joinPoint) {
		
		System.out.println(joinPoint.getTarget().getClass().getName() + " 类的" +  joinPoint.getSignature().getName() + "方法运行开始----------------方法参数是： " + Arrays.toString(joinPoint.getArgs()));
	}
	 
	@After("pointCut()")
	public void logEnd() {
		System.out.println("方法运行结束=================");
	}
	
	@AfterReturning(value = "pointCut()", returning = "result")
	public void logAfterReturn(Object result) {
		System.out.println("方法返回之后=================返回结果： " + result);
	}
}
