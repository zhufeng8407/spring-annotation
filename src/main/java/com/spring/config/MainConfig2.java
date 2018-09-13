package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

import com.spring.bean.Color;
import com.spring.bean.Person;

@Configuration
//@ComponentScan(value="com.spring")
@ComponentScan(value="com.spring", includeFilters = {
		@Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
		@Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
}, useDefaultFilters = false)
@Import(Color.class)	//Id默认是组件的全类名
public class MainConfig2 {
	
	/**
	 * Scope	注解See ConfigurableBeanFactory # SCOPE_PROTOTYPE
	 * SCOPE_PROTOTYPE 多实例 启动时不会调用
	 * SCOPE_SINGLETON 单例默认	启动时调用
	 * 
	 * 懒加载:
	 * 		单实例bean:默认在容器启动的时候创建对象
	 * 		懒加载：容器启动时不创建对象，第一次使用时创建
	 */
//	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	@Lazy
	@Bean
	public Person person() {
		return new Person("zhangsan", 40);
	}
}
