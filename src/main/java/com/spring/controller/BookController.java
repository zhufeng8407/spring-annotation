package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.spring.service.BookService;

@Controller
public class BookController {

	@Qualifier("bookService2")
	@Autowired
	private BookService bookService;
	
	@Qualifier("bookService2")
	private BookService bookService2;
	
	public void print() {
		System.out.println(bookService);
	}
	
	public void print2() {
		System.out.println(bookService2);
	}

	@Override
	public String toString() {
		return "BookController [bookService=" + bookService + "]";
	}
	
}
