package com.example.example.service;

import com.example.example.controller.dto.ExampleDto;
import org.springframework.web.HttpMediaTypeNotAcceptableException;

public interface ExampleService {

    ExampleDto doSome(ExampleDto input) throws HttpMediaTypeNotAcceptableException;
}
