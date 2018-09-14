package com.spring.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Cat {

	public Cat() {
		System.out.println("Cat construct=====");
	}

	@PreDestroy
	public void destroy() throws Exception {
		System.out.println("Cat destroy=====");
	}

	@PostConstruct
	public void postConstruct() throws Exception {
		System.out.println("Cat PostConstruct init");
		
	}
	
}
