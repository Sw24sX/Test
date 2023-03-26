package com.example.example.service;

import com.example.example.controller.dto.ExampleDto;
import com.example.example.controller.dto.PrivateDto;
import com.example.example.controller.dto.PublicDto;
import com.example.example.controller.dto.SecretDto;
import org.springframework.web.HttpMediaTypeNotAcceptableException;

import java.util.List;

public interface ExampleService {

    ExampleDto doSome(ExampleDto input) throws HttpMediaTypeNotAcceptableException;

    List<PublicDto> getListPublicDto();

    List<PrivateDto> getPrivateInfo();

    SecretDto getSecret();
}
