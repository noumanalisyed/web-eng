package com.blog.app.ws12;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

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
