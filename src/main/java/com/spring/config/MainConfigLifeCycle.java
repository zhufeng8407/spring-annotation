package com.spring.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.spring.bean.Cat;
import com.spring.bean.Person;

/**
 * 1. bean注解的initMethod, destroyMethod
 * 		Person construct=====
		Person init=====
		Person destroy=====	容器关闭时
		
   2.	InitializingBean, DisposableBean接口
   		afterPropertiesSet bean创建完成并属性赋值完成后调用
   		destroy		容器关闭时
   
   3. 可以使用JSR250规范里面的
   			@PostConstruct: 在bean创建完成并且属性赋值完成后调用
   			@PreDestroy: 在容器销毁bean之前通知我门进行清理工作
   			
   	4. BeanPostProcessor
 * 
 * @author zhufeng
 *
 */
@Configuration
public class MainConfigLifeCycle {
	
//	@Bean(initMethod = "init", destroyMethod="destroy")
//	public Person person() {
//		return new Person();
//	}
	
	@Bean
	public Cat cat() {
		return new Cat();
	}
	
	
}
