package com.spring.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.spring.service.BookService;

/**
 * 自动装配:
 * 		spring利用依赖注入（DI），完成对IOC容器中各个组件的依赖关系赋值。
 * 
 * 1. @Autowired 自动装配
 * 		1. 默认优先按照类型去容器中找对应的组件，.class，找到就赋值
 * 		2. 如果找到多个相同类型的组件，再将属性的名称作为组件的ID去容器中查找，
 * 				applicationContext.getBean("bookService")
 * 		3. @Qualifier("bookService2")
 * 		4. @Primary	首选装配 
 * 2. @Resource 注解
 * 
 * 3. Autowired: 构造器，参数，方法，属性
 * 
 * 4. 自定义组件想要使用spring容器底层的一些组件（applicationcontext，BeanFactory）
 * 		让自定义组件实现***aware，在创建对象的时候会调用接口规定的方法注入组件。
 * 		把spring底层一些组件注入到自定义的bean中
 * 		***aware: 功能使用XXXProcessor
 * 		ApplicationContextAware = ApplicationContextAwareProcessor
 * 
 * 		
 * @author zhufeng
 *
 */
@Configuration
@ComponentScan(value= {"com.spring.bean", "com.spring.service", "com.spring.controller"})
public class MainConfigOfAutowire {

	@Bean("bookService2")
	public BookService bookService() {
		return new BookService();
	}
}
