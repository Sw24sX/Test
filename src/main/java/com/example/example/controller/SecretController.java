package com.example.example.controller;

import com.example.example.controller.dto.SecretDto;
import com.example.example.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("secret")
@RequiredArgsConstructor
public class SecretController {

    private final ExampleService exampleService;

    @GetMapping("secret")
    public SecretDto getSecret() {
        return exampleService.getSecret();
    }
}
