package org.example.controller;

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
    public String echo(@PathVariable String str) {
        return "Hi " + str;
    }

    @GetMapping("/feign/echo/{str}")
    public String feignEcho(@PathVariable String str) {
        return echoService.echo("feign " + str);
    }
}
