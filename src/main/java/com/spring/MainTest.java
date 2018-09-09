package com.spring;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.bean.Person;
import com.spring.config.MainConfig;

public class MainTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
//		new ClassPathXmlApplicationContext();	这个是获取配置文件方式的容器
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		
		Optional.ofNullable(applicationContext.getBean(Person.class)).ifPresent(System.out::println);
		
		Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
		
	}

}
