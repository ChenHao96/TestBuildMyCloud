package org.example.rest;

import org.example.rest.fallback.EchoServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "server-2", fallback = EchoServiceFallback.class)
public interface EchoService {

    @GetMapping("/echo/{str}")
    String echo(@PathVariable("str") String str);
}
