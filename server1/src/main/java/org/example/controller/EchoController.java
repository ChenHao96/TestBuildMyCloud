package org.example.controller;

import org.example.rest.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

    @Autowired
    private EchoService echoService;

    @GetMapping("/echo/{str}")
//    @SentinelResource("echo_")
    public String echo(@PathVariable String str) {
        return "Hi " + str;
    }

    @GetMapping("/feign/echo")
//    @SentinelResource("feign_echo")
    public String feignEcho() {
        return echoService.echo("feign Steven");
    }
}
