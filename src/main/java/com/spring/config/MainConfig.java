package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.spring.bean.Person;

@Configuration
//@ComponentScan(value="com.spring")
@ComponentScan(value="com.spring", includeFilters = {
		@Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
		@Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
}, useDefaultFilters = false)
public class MainConfig {

	@Bean
	public Person person() {
		return new Person("lijian", 40);
	}
}
