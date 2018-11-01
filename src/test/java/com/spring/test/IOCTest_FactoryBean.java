package com.spring.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.config.FactoryConfig;
import com.spring.factory.MyFactoryBean;

public class IOCTest_FactoryBean {

	@Test
	public void test01() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				FactoryConfig.class);
		
		System.out.println(applicationContext.getBean("myFactoryBean").getClass().getName());
		
		applicationContext.close();
	}
	
}
