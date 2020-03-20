package org.example.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.example.rest.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class EchoController {

    @Autowired
    private EchoService echoService;

    @GetMapping("/echo/{str}")
    @SentinelResource(value = "echo_", blockHandler = "blockEchoHandler", defaultFallback = "echoFallback")
    public String echo(@PathVariable String str) {
        return "Hi " + str;
    }

    @GetMapping("/feign/echo/{str}")
//    @SentinelResource(value = "feign_echo", fallback = "feignEchoFallback", blockHandler = "handleException", blockHandlerClass = {ExceptionUtil.class})
    public String feignEcho(@PathVariable String str) {
        return echoService.echo("feign " + str);
    }

    public String feignEchoFallback(String str, Throwable ex) {
        log.warn("str:{}", str, ex);
        return "不好意思我走神了!";
    }

    public String echoFallback() {
        return "您的网络好像有点问题!";
    }

    public void blockEchoHandler(String str, BlockException ex) {
        log.warn("Oops: {} str:{}", ex.getClass().getCanonicalName(), str);
    }
}
