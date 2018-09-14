package com.spring.bean;

import org.springframework.beans.factory.annotation.Value;

public class Person {
	
	// 使用@Value赋值
	// 1. 基本数值	直接写 (“张三”)
	// 2. 可以写Spel， #{}计算数值
	// 3. 可以写$P{} 取出配置文件中的值
	
	@Value("${person.name}")
	private String name;

	@Value("#{20-2}")
	private int age;

	public String getName() {
		return name;
	}
	
	
	
	public Person() {
		System.out.println("Person construct=====");
	}



	public void init() {
		System.out.println("Person init=====");
	}
	
	public void destroy() {
		System.out.println("Person destroy=====");
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}



	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
