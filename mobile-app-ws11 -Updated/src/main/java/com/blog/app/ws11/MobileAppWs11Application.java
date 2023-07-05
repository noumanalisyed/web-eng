package com.blog.app.ws11;

import com.blog.app.ws11.security.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@EntityScan("com.blog.app.ws11")
@SpringBootApplication
public class MobileAppWs11Application {


    public static void main(String[] args) {
        SpringApplication.run(MobileAppWs11Application.class, args);
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
