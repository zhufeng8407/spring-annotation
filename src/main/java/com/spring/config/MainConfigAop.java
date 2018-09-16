package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.spring.aop.LogAspects;
import com.spring.aop.MathCalculator;

/**
 * AOP使用：
 * 1. 导入Aop模块（spring-aspects)
 * 2. 定义一个业务逻辑类
 * 3. 定义一个日志切面类（LogAspects）
 * 	通知方法：
 * 		1. 前置通知（@Before）: 在方法运行之前调用
 * 		2. 后置通知 (@After)： 在方法运行结束后调用，无论方法正常结束还是异常结束
 *      3. 返回通知 (@AfterRturning)：正常返回之后运行
 *      4. 异常通知 (@AfterThrowing)
 *      5. 环绕通知 (@Around)
 * 
 * 4. 给切面类的目标方法标注何时何地运行（通知注解）
 * 5. 将切面类和业务逻辑类（目标方法所在类）都加入到容器
 * 6. 必须告诉spring哪个类是切面类（给切面类加上@Aspect注解）
 * 7. 给配置类中加入@EnableAspectJAutoProxy 开启基于注解的AOP模式
 * 
 * AOP原理：
 * 		@EnableAspectJAutoProxy：
 * 		1. EnableAspectJAutoProxy是什么
 * 			@Import(AspectJAutoProxyRegistrar.class): 给容器导入组件
 * 
 * @author zhufeng
 *
 */

@EnableAspectJAutoProxy
@Configuration
public class MainConfigAop {

	@Bean
	public MathCalculator mathCalculator() {
		return new MathCalculator();
	}
	
	@Bean
	public LogAspects logAspects() {
		return new LogAspects();
	}
}
