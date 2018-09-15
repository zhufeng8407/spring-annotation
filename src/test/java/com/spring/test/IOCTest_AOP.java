package com.spring.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.MathCalculator;
import com.spring.config.MainConfigAop;

public class IOCTest_AOP {

	@Test
	public void test01() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				MainConfigAop.class);
		
		MathCalculator calCulator = applicationContext.getBean(MathCalculator.class);
		System.out.println(calCulator.div(8, 2));
		
		applicationContext.close();
	}
}
