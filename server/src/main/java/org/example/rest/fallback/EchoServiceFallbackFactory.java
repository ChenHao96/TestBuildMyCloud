package org.example.rest.fallback;

import feign.hystrix.FallbackFactory;
import org.example.rest.EchoService;
import org.springframework.stereotype.Component;

@Component
public class EchoServiceFallbackFactory implements FallbackFactory<EchoService> {
    @Override
    public EchoService create(Throwable throwable) {
        return new EchoServiceFallback(throwable);
    }
}
