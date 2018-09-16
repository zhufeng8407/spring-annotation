package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.bean.Car;
import com.spring.bean.Cat;
import com.spring.bean.MyBeanPostProcessor;

/**
 * 1. bean注解的initMethod, destroyMethod
 * 		Person construct=====
		Person init=====
		Person destroy=====	容器关闭时
		
   2.	InitializingBean, DisposableBean接口
   		afterPropertiesSet bean创建完成并属性赋值完成后调用
   		destroy		容器关闭时
   
   3. 可以使用JSR250规范里面的
   			@PostConstruct: 在bean创建完成并且属性赋值完成后调用
   			@PreDestroy: 在容器销毁bean之前通知我门进行清理工作
   			
   	4. BeanPostProcessor[interface]: bean的后置处理器
   			在bean初始化前后进行一些处理工作
   			postProcessBeforeInitialization: Apply this BeanPostProcessor to the given new bean instance <i>before</i> any bean
	 										* initialization callbacks (like InitializingBean's {@code afterPropertiesSet}
	 										* or a custom init-method). The bean will already be populated with property values.
	 										* @return the bean instance to use, either the original or a wrapped one;
   			postProcessAfterInitialization: Apply this BeanPostProcessor to the given new bean instance <i>after</i> any bean
	 										* initialization callbacks (like InitializingBean's {@code afterPropertiesSet}
	 										* or a custom init-method). The bean will already be populated with property values.
	5. BeanPostProcessor执行顺序：遍历得到所有的BeanPostProcessor，挨个执行BeforeInitialization一旦返回null则跳出for循环，不会执行后面的
								BeanPostProcessor的BeforeInitialization。
								
								populateBean(beanName, mbd, instanceWrapper);赋值。
								赋值完成后执行初始化，
	
								applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
								invokeInitMethods(beanName, wrappedBean, mbd);
								applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
 * 
 * @author zhufeng
 *
 */
@Configuration
public class MainConfigLifeCycle {
	
//	@Bean(initMethod = "init", destroyMethod="destroy")
//	public Person person() {
//		return new Person();
//	}
	
	@Bean
	public Cat cat() {
		return new Cat();
	}
	
	@Bean
	public Car car() {
		return new Car();
	}
	
	@Bean
	public MyBeanPostProcessor myBeanPostProcessor() {
		return new MyBeanPostProcessor();
	}
	
}
