package com.spring.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Scope;

import com.spring.bean.Person;

@Configuration
//@ComponentScan(value="com.spring")
@ComponentScan(value="com.spring", includeFilters = {
		@Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
		@Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
}, useDefaultFilters = false)
public class MainConfig {
	
	/**
	 * Scope	注解See ConfigurableBeanFactory # SCOPE_PROTOTYPE
	 * SCOPE_PROTOTYPE 多实例 启动时不会调用
	 * SCOPE_SINGLETON 单例默认	启动时调用
	 * @return
	 */
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	@Bean
	public Person person() {
		return new Person("lijian", 40);
	}
}
