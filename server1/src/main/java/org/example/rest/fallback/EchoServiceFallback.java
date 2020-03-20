package org.example.rest.fallback;

import lombok.extern.slf4j.Slf4j;
import org.example.rest.EchoService;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EchoServiceFallback implements EchoService {

    @Override
    public String echo(String str) {
        log.warn("fallback... str:{}",str);
        return "网络好像有点问题！";
    }
}
