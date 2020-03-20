package org.example.dubbo.service;

import org.apache.dubbo.config.annotation.Service;

@Service(version = "0.0.1")
public class EchoServiceImpl implements EchoService {

    @Override
    public String echoHello(String msg) {
        return String.format("Hello dubbo %s!", msg);
    }
}
