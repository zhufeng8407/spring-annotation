package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	public void print() {
		System.out.println(bookService);
	}

	@Override
	public String toString() {
		return "BookController [bookService=" + bookService + "]";
	}
	
}
