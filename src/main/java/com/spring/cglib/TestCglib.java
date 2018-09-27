package com.spring.cglib;

import org.springframework.cglib.proxy.Enhancer;

public class TestCglib {

	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(HelloServiceImpl.class);
		enhancer.setCallback(new HelloMethodInterceptor());
		HelloServiceImpl impl = (HelloServiceImpl) enhancer.create();
		impl.sayHello();
	}

}
