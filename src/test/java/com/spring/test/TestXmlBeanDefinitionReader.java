package com.spring.test;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class TestXmlBeanDefinitionReader {

	@Test
	public void test01() {
		ClassPathResource res = new ClassPathResource("beans.xml");
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
		System.out.println(reader.loadBeanDefinitions(res));
	}
}
