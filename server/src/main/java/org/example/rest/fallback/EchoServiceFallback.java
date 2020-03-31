package org.example.rest.fallback;

import lombok.extern.slf4j.Slf4j;
import org.example.rest.EchoService;

@Slf4j
public class EchoServiceFallback implements EchoService {

    @Override
    public String echo(String str) {
        return "网络好像有点问题！";
    }
}
