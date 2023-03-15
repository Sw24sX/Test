package com.example.example.controller;

import com.example.example.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
@RequiredArgsConstructor
public class TestController {

    private final ExampleService exampleService;

//    @GetMapping("ts/{test}")
//    public String test(@PathVariable String test) throws HttpMediaTypeNotAcceptableException {
//        return exampleService.doSome(test);
//    }
}
