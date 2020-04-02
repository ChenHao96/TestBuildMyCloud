package org.example.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.example.commons.utils.Constant;
import org.example.commons.utils.encrypt.AESUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RefreshScope
public class MyGatewayFilter implements GlobalFilter, Ordered {

    private static final String X_CLIENT_TOKEN = "x-client-token";
    private static final String IGNORE_AUTH_METHOD = "post";

    @Value("${ignore.auth.url.regex:\\\\w*/login}")
    private String ignoreAuthUrlRegex;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String method = request.getMethodValue();
        String url = request.getPath().value();
        if (!url.matches(ignoreAuthUrlRegex)) {
            String token = request.getHeaders().getFirst(X_CLIENT_TOKEN);
            if (!StringUtils.isEmpty(token)) {
                try {
                    AESUtils.decrypt(token, Constant.TOKEN_AES_PASSWORD);
                    return chain.filter(exchange);
                } catch (Exception ignored) {
                    log.warn("token decrypt fail.", ignored);
                }
            }
        } else if (!StringUtils.isEmpty(method) && method.equalsIgnoreCase(IGNORE_AUTH_METHOD)) {
            return chain.filter(exchange);
        }
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        return exchange.getResponse().setComplete();
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
