package com.project.productmicroservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableJpaRepositories(basePackages = "com.project.productmicroservice.repositories")
public class ProductConfiguration {
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
