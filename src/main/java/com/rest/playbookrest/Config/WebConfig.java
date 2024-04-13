package com.rest.playbookrest.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200/", "http://localhost:8080/")
                .allowedMethods("OPTIONS","GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*","Some-Header-x", "Authorization","origin", "content-type" , "X-CSRF-TOKEN" )
                .exposedHeaders(String.valueOf(Arrays.asList("Authorization")),"X-API-Limit");
    }

}