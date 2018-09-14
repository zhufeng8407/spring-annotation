package com.spring.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;


public class IOCTest_time {

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	@Test
	public void testTime() {
		
		System.out.println(LocalDateTime.parse("2018-09-14 15:39:38", FORMATTER).plusSeconds(30)
				.plusSeconds(new Long("7200")).isBefore(LocalDateTime.now()));
	}
}
