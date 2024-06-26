package com.redolf.gateway.config;

import com.redolf.gateway.utils.AppConstant;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route(AppConstant.STUDENT_SERVICE_KEY, spec -> spec
                        .path("/api/v1/student-service/**")
                        .filters(filter -> filter.stripPrefix(3))
                        .uri("http://localhost:8001"))
                .route(AppConstant.PAYMENT_SERVICE_KEY,spec -> spec
                        .path("/api/v1/payment-service/**")
                        .filters(filter -> filter.stripPrefix(3))
                        .uri("http://localhost:8002"))
                .build();
    }
}
