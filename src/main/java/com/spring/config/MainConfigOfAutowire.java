package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.spring.service.BookService;

/**
 * 自动装配:
 * 		spring利用依赖注入（DI），完成对IOC容器中各个组件的依赖关系赋值。
 * 
 * 1. @Autowired 自动装配
 * 
 * @author zhufeng
 *
 */
@Configuration
@ComponentScan(value= {"com.spring.bean", "com.spring.service", "com.spring.controller"})
public class MainConfigOfAutowire {

	@Bean
	public BookService bookService() {
		return new BookService();
	}
}
