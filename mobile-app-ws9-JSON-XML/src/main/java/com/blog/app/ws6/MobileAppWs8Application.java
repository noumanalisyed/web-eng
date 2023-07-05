package com.blog.app.ws6;

import com.blog.app.ws6.security.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@EntityScan("com.blog.app.ws6")
@SpringBootApplication
public class MobileAppWs8Application {


    public static void main(String[] args) {
        SpringApplication.run(MobileAppWs8Application.class, args);
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SpringApplicationContext springApplicationContext() {
        return new SpringApplicationContext();
    }

    @Bean
    public AppProperties getAppProperties(){
        return new AppProperties();
    }
}
