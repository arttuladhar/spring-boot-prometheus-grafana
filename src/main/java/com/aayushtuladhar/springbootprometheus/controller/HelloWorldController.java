package com.aayushtuladhar.springbootprometheus.controller;

import com.aayushtuladhar.springbootprometheus.domain.HelloResult;
import com.aayushtuladhar.springbootprometheus.service.HelloWorldService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class HelloWorldController {

    private final HelloWorldService helloWorldService;

    @GetMapping("/")
    public HelloResult sayHello() {
        return helloWorldService.getInfo();
    }


}