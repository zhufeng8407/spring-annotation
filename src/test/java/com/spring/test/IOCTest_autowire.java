package com.spring.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.config.MainConfigOfAutowire;
import com.spring.controller.BookController;
import com.spring.service.BookService;

public class IOCTest_autowire {

	@Test
	public void test01() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				MainConfigOfAutowire.class);
		
		BookController bookController = applicationContext.getBean(BookController.class);
		bookController.print();
		
		System.out.println(applicationContext.getBean(BookService.class));
		
		System.out.println(applicationContext.getBean("bookService"));
		applicationContext.close();

	}
}
