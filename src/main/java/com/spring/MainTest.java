package com.spring;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.config.MainConfigLifeCycle;

public class MainTest {

	public static void main(String[] args) {
//		new ClassPathXmlApplicationContext();	这个是获取配置文件方式的容器
		
//		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigLifeCycle.class);
		
		System.out.println("容器创建完成======");
//		Optional.ofNullable(applicationContext.getBean(Person.class)).ifPresent(System.out::println);
		
		Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
		
		applicationContext.close();
	}

}
