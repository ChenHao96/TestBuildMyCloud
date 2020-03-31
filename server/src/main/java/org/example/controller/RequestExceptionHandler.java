package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class RequestExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handlerException(HttpServletRequest request) {
        return "网络好像有点问题！";
    }
}
