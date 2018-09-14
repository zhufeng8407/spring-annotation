package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.spring.bean.Person;

@Configuration
@PropertySource(value = {"classpath:/person.properties"})
public class MainConfigPropertyValue {
	
	@Bean
	public Person person() {
		return new Person();
	}
}
