package com.spring.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;


public class HelloMethodInterceptor implements MethodInterceptor{

	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy proxy) throws Throwable {
		System.out.println("before--------------" + method.getName());
		Object object = proxy.invokeSuper(o, objects);
		System.out.println("After--------------" + method.getName());
		return object;
	}

}
