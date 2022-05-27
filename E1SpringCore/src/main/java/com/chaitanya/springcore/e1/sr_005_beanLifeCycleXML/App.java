package com.chaitanya.springcore.e1.sr_005_beanLifeCycleXML;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("com.chaitanya.springcore.e1.sr_005/config.xml");
//        context.registerShutdownHook();
        System.out.println("before");
        Student s1 = (Student)context.getBean("student1");
        System.out.println(s1);
        context.registerShutdownHook();
        System.out.println("after");
    }
}
