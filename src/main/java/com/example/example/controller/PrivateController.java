package com.example.example.controller;

import com.example.example.controller.dto.PrivateDto;
import com.example.example.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("private")
@RequiredArgsConstructor
public class PrivateController {

    private final ExampleService exampleService;

    @GetMapping("info")
    public List<PrivateDto> getInfo() {
        return exampleService.getPrivateInfo();
    }
}
