package com.example.example.controller;

import com.example.example.controller.dto.PublicDto;
import com.example.example.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("public")
@RequiredArgsConstructor
public class PublicController {

    private final ExampleService exampleService;

    @GetMapping("list")
    public List<PublicDto> listPublic() {
        return exampleService.getListPublicDto();
    }
}
