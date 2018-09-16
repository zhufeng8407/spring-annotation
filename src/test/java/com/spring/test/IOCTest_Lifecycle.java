package com.spring.test;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.bean.Cat;
import com.spring.config.MainConfigLifeCycle;

public class IOCTest_Lifecycle {

	@Test
	public void test01() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				MainConfigLifeCycle.class);
		printBeans(applicationContext);
		System.out.println(applicationContext.getBean(Cat.class));
		
		applicationContext.close();

	}

	private void printBeans(AnnotationConfigApplicationContext applicationContext) {
		Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
	}
	
}
