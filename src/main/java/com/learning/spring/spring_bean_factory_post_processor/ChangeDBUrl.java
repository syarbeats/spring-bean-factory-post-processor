package com.learning.spring.spring_bean_factory_post_processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class ChangeDBUrl implements BeanFactoryPostProcessor {

	private String dbUrl;
	
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory arg0) throws BeansException {
		
		System.out.println("In PostBeanProcessor...");
		BeanDefinition bd = arg0.getBeanDefinition("dataSource");
		
		if(bd.hasPropertyValues()) {
			MutablePropertyValues pvs = bd.getPropertyValues();
			PropertyValue[] pvArray = pvs.getPropertyValues();
			
			for(PropertyValue pv:pvArray) {
				System.out.println("pv -- "+pv.getName());
				
				if(pv.getName().equals("url")) {
					pvs.add(pv.getName(), "jdbc:mysql//localhost:3306/DevDB");
					this.setDbUrl(pvs.get("url").toString());
				}
			}
		}

	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

}
