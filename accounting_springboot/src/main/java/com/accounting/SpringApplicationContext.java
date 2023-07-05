package com.accounting;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;

public class SpringApplicationContext implements ApplicationContextAware {

    private static ApplicationContext context;


    public static Object getBean(String beanName){
        return context.getBean(beanName);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringApplicationContext.context = applicationContext;
    }
}
