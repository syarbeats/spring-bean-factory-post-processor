package com.learning.spring.spring_bean_factory_post_processor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
        ChangeDBUrl dbUrl = (ChangeDBUrl) context.getBean("postBeanProcessorTest");
        System.out.println("Development DB URL: "+dbUrl.getDbUrl());
        context.close();
    }
}
