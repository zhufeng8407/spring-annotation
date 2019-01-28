package com.spring.test;

import com.spring.bean.Color;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCTest_XML {

    @Test
    public void test01() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        System.out.println("容器启动了。。。。。。。");
        Color color = (Color) applicationContext.getBean("color");

        ((ClassPathXmlApplicationContext) applicationContext).close();
    }
}
