package org.example.rest.fallback;

import lombok.extern.slf4j.Slf4j;
import org.example.rest.EchoService;

@Slf4j
public class EchoServiceFallback implements EchoService {

    private Throwable throwable;

    EchoServiceFallback(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public String echo(String str) {
        log.warn("fallback... str:{}", str, throwable);
        return "网络好像有点问题！";
    }
}
