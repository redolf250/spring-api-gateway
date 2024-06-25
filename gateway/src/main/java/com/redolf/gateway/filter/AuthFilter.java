package com.redolf.gateway.filter;

import com.redolf.gateway.dto.ApiKey;
import com.redolf.gateway.utils.HelperMethods;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

import static com.redolf.gateway.utils.HelperMethods.*;

@Slf4j
@Component
public class AuthFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        List<String> apiKeyHeader = exchange.getRequest().getHeaders().get("gatewaykey");
        log.info("api key: {}", apiKeyHeader);

        Route route = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);
        String routeId = route!=null ? route.getId() : null;
        log.info("route Id: {}", routeId);

        if (routeId == null || CollectionUtils.isEmpty(apiKeyHeader) || !isAuth(routeId,apiKeyHeader.get(0))){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Wrong api key!!!");
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }

    private boolean isAuth(String routeId, String key){
        ApiKey record = getApiKey(key);
        if (record != null){
             return record.getServices().contains(routeId);
        }else {
            return false;
        }
    }
}
