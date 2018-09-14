package com.spring.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.config.MainConfigOfAutowire;
import com.spring.controller.BookController;

public class IOCTest_autowire {

	@Test
	public void test01() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				MainConfigOfAutowire.class);
		// 此处会不知道去找哪一个，因为我门装配了2个BookService
//		BookService bookService = applicationContext.getBean(BookService.class);
		System.out.println(applicationContext.getBean("bookService"));
		System.out.println(applicationContext.getBean("bookService2")	);
		// 默认加载bookService
		BookController bookController = applicationContext.getBean(BookController.class);
		bookController.print();
		bookController.print2();
		
		
//		System.out.println(applicationContext.getBean("bookService2"));
		applicationContext.close();

	}
}
