package com.spring.test;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.bean.Person;
import com.spring.config.MainConfigLifeCycle;
import com.spring.config.MainConfigPropertyValue;

public class IOCTest_PropertyValue {

	@Test
	public void test01() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				MainConfigPropertyValue.class);
		printBeans(applicationContext);
		System.out.println(applicationContext.getBean(Person.class));
		
		applicationContext.close();

	}

	private void printBeans(AnnotationConfigApplicationContext applicationContext) {
		Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
	}
}
