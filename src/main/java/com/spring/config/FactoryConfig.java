package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.factory.MyFactoryBean;

@Configuration
public class FactoryConfig {

	@Bean
	public MyFactoryBean myFactoryBean() {
		return new MyFactoryBean();
	}
}
