package com.example.example.service.impl;

import com.example.example.controller.dto.ExampleDto;
import com.example.example.exception.ExampleException;
import com.example.example.service.ExampleService;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpMediaTypeNotAcceptableException;

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
}
