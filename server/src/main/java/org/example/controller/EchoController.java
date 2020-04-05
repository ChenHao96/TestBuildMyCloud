package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.rest.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RefreshScope
@RestController
public class EchoController {

    private static final ThreadLocal<HttpServletRequest> servletRequest = new ThreadLocal<>();

    @Value("${params.userName}")
    private String userName;

    @Autowired
    private EchoService echoService;

    @ModelAttribute
    public void setHttpServletRequest(HttpServletRequest request) {
        servletRequest.set(request);
    }

    public static HttpServletRequest getRequest() {
        return servletRequest.get();
    }

    @GetMapping("/echo/{str}")
    public String echo(@PathVariable String str) {
        int port = getRequest().getServerPort();
        return String.format("Hi %s. userName:%s. Port:%d", str, userName, port);
    }

    @GetMapping("/feign/echo/{str}")
    public String feignEcho(@PathVariable String str) {
        return echoService.echo("feign " + str);
    }
}
