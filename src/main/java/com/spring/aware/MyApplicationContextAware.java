package com.spring.aware;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationContextAware implements ApplicationContextAware {
	
	private ApplicationContext applicationContext;
	
	

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	public void printAllBeans() {
		Arrays.stream(this.applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
		
		
	}

}
