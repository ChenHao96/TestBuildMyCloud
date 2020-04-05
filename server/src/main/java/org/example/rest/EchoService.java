package org.example.rest;

import org.example.rest.fallback.EchoServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@RefreshScope //TODO:开启刷新也不会被动态的修改
@FeignClient(value = "${provider.rest.service}", fallback = EchoServiceFallback.class)
public interface EchoService {

    @GetMapping("/echo/{str}")
    String echo(@PathVariable("str") String str);
}
