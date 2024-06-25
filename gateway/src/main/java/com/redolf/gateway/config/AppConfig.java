package com.redolf.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("service1",predicateSpec -> predicateSpec
                        .path("/**")
                        .uri("http://localhost:8002/api/v1"))
                .route("service2",predicateSpec -> predicateSpec
                        .path("/**")
                        .uri("http://localhost:8002/api/v1"))
                .build();
    }
}
