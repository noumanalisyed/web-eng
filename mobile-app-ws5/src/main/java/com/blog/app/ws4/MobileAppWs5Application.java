package com.blog.app.ws4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@EntityScan("com.blog.app.ws4")
@SpringBootApplication
public class MobileAppWs5Application {

    public static void main(String[] args) {
        SpringApplication.run(MobileAppWs5Application.class, args);
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
