package com.example.example.controller;

import com.example.example.service.AuthServiceApi;
import com.example.example.service.dto.request.CreateUserInfoRequest;
import com.example.example.service.dto.response.UserInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

@RequiredArgsConstructor
@RestController
@RequestMapping("auth")
@Validated
public class AuthController {

    private final AuthServiceApi authServiceApi;

    @PostMapping("registration")
    public UserInfoDto registration(@Valid @RequestBody CreateUserInfoRequest createUserInfoRequest) {
        return authServiceApi.registerUser(createUserInfoRequest);
    }

    @PostMapping("login")
    public UserInfoDto login(Principal principal) {
        return authServiceApi.login(principal.getName());
    }

    @PostMapping("logout")
    public void fakeLogout() {
        //NOOP
    }
}
