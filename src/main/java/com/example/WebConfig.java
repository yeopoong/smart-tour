package com.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
        .allowedOrigins("*")
        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
        .allowedHeaders("Origin", "Accept", "X-Requested-With", "X-Auth-Token", "Content-Type", "Access-Control-Request-Method", "Access-Control-Request-Headers", "Authorization")
        .allowCredentials(false)
        .maxAge(3600);
	}
}
