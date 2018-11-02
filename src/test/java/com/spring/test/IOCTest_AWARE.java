package com.spring.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aware.MyApplicationContextAware;
import com.spring.config.AwareConfig;

public class IOCTest_AWARE {

	@Test
	public void test01() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				AwareConfig.class);
		
		MyApplicationContextAware contextAware = applicationContext.getBean(MyApplicationContextAware.class);
		
		contextAware.printAllBeans();
		applicationContext.close();
	}
}
