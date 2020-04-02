package org.example.gateway.config;

import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.example.commons.model.HttpResult;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Slf4j
public class GatewayExceptionHandler implements WebExceptionHandler, Ordered {

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        exchange.getResponse().setStatusCode(HttpStatus.OK);
        byte[] bytes = JSON.toJSONString(buildErrorResult(ex)).getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bytes);
        exchange.getResponse().getHeaders().set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        return exchange.getResponse().writeWith(Flux.just(buffer));
    }

    private HttpResult<?> buildErrorResult(Throwable ex) {
        HttpResult<?> vo = new HttpResult<>(HttpStatus.EXPECTATION_FAILED.value(),"系统繁忙,请稍后再试!");
        if (ex instanceof FlowException) {
            vo.setMsg("访问的人太多了,要稍等一下哦!");
            vo.setCode(HttpStatus.TOO_MANY_REQUESTS.value());
        } else if (ex instanceof ResponseStatusException) {
            HttpStatus status = ((ResponseStatusException) ex).getStatus();
            switch (status) {
                case NOT_FOUND:
                    vo.setMsg("访问的内容，丢失了或是已删除!");
                    break;
                case UNAUTHORIZED:
                    vo.setMsg("对不起,您没有访问权限!");
                    break;
                default:
                    vo.setMsg("系统繁忙,请稍后再试!");
                    break;
            }
            vo.setCode(status.value());
        }
        return vo;
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
