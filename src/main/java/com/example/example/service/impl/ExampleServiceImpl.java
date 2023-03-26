package com.example.example.service.impl;

import com.example.example.controller.dto.ExampleDto;
import com.example.example.controller.dto.PrivateDto;
import com.example.example.controller.dto.PublicDto;
import com.example.example.controller.dto.SecretDto;
import com.example.example.exception.ExampleException;
import com.example.example.service.ExampleService;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpMediaTypeNotAcceptableException;

import java.util.List;

@Service
public class ExampleServiceImpl implements ExampleService {

    @Override
    public ExampleDto doSome(ExampleDto input) throws HttpMediaTypeNotAcceptableException {

        if (input.getName().equals("test")) {
            throw new ExampleException("example");
        }
        input.setAge(input.getAge() + 1);
        input.setName(input.getName() + "test");
        return input;
    }

    @Override
    public List<PublicDto> getListPublicDto() {
        return List.of(
                new PublicDto("property value 1"),
                new PublicDto("property value 1")
        );
    }

    @Override
    public List<PrivateDto> getPrivateInfo() {
        return List.of(
                new PrivateDto(1),
                new PrivateDto(2)
        );
    }

    @Override
    public SecretDto getSecret() {
        return new SecretDto(true);
    }
}
