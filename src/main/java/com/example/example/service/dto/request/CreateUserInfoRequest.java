package com.example.example.service.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class CreateUserInfoRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotEmpty
    private char[] password;

    @NotBlank
    private String username;
}
