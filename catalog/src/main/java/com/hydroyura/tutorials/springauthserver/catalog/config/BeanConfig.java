package com.hydroyura.tutorials.springauthserver.catalog.config;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    Faker faker() {
        return new Faker();
    }

}
