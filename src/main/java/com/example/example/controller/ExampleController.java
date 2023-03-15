package com.example.example.controller;

import com.example.example.controller.dto.ExampleDto;
import com.example.example.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("example")
@RequiredArgsConstructor
public class ExampleController {

    private final ExampleService exampleService;

    @PatchMapping("test")
    public ExampleDto otherName(@RequestBody ExampleDto name) throws HttpMediaTypeNotAcceptableException {

        return exampleService.doSome(name);
    }
}
