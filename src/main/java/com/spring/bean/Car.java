package com.spring.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Car implements InitializingBean, DisposableBean {

	public Car() {
		System.out.println("Car construct=====");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Car destroy=====");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Car afterPropertiesSet");
		
	}
}
