package org.example.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.example.dubbo.service.EchoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

    @Reference(version = "0.0.1")
    private EchoService echoService;

    @GetMapping("/echo/{str}")
    public String echo(@PathVariable String str) {
        return "Hello " + str;
    }

    @GetMapping("/dubbo/echo/{str}")
    public String dubboEcho(@PathVariable String str) {
        return echoService.echoHello(str);
    }
}
