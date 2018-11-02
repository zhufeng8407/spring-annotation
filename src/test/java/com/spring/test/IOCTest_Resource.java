package com.spring.test;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.config.ResourceConfig;
import com.spring.resource.MyResourcePatternResolver;

public class IOCTest_Resource {

	@Test
	public void test01() throws IOException {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				ResourceConfig.class);
		
		MyResourcePatternResolver resolver = applicationContext.getBean(MyResourcePatternResolver.class);
		
		Arrays.stream(resolver.getResources("classpath*:")).forEach(e -> System.out.println(e.getFilename()));
		
		applicationContext.close();
	}
}
