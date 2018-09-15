package com.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

@Component
public class Dog implements ApplicationContextAware, BeanClassLoaderAware, BeanNameAware, EmbeddedValueResolverAware {

	ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		
		System.out.println(applicationContext);
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("bean name is: " + name);
		
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("classLoader is + " + classLoader.toString());
	}

	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		System.out.println(resolver.resolveStringValue("你好： ${os.name}, 20 * 18 = #{20 * 18}"));
		
	}

}
