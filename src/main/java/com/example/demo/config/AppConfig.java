package com.example.demo.config;

import com.example.demo.repository.AnotherBookRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public AnotherBookRepositoryImpl anotherBookRepository(){
        return new AnotherBookRepositoryImpl();
    }

}
