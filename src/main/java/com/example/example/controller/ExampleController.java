package com.example.example.controller;

import com.example.example.config.prepare.SimpleProperties;
import com.example.example.controller.dto.ExampleDto;
import com.example.example.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("example")
@RequiredArgsConstructor
public class ExampleController {

    private final ExampleService exampleService;
    private final SimpleProperties simpleProperties;

    private final ExampleDto exampleDto;

    private final ExampleDto profile;

    @GetMapping("test")
    public SimpleProperties otherName(@RequestBody ExampleDto name) {

        return simpleProperties;
    }

    @GetMapping("property")
    public ExampleDto getExampleDtoByProperty() {
        return exampleDto;
    }

    @GetMapping("profile")
    public ExampleDto getExampleDtoByProfile() {
        return profile;
    }
}
