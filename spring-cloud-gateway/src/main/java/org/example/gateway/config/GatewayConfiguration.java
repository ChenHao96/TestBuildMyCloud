package org.example.gateway.config;

import com.alibaba.csp.sentinel.adapter.gateway.sc.SentinelGatewayFilter;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.WebExceptionHandler;

//@Configuration
public class GatewayConfiguration {

    @Bean
    public WebExceptionHandler sentinelGatewayBlockExceptionHandler() {
        return new GatewayExceptionHandler();
    }

    @Bean
    public GlobalFilter sentinelGatewayFilter() { return new SentinelGatewayFilter(); }
}
