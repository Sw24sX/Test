package com.example.example.controller;

import com.example.example.service.UserInfoServiceApi;
import com.example.example.service.dto.request.CreateUserInfoRequest;
import com.example.example.service.dto.response.UserInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user-info")
@RequiredArgsConstructor
public class UserInfoController {

    private final UserInfoServiceApi userInfoServiceApi;

    @GetMapping
    public UserInfoDto getById(@RequestParam("user_id") Long id) {
        return userInfoServiceApi.getUserInfoById(id);
    }

    @PostMapping
    public UserInfoDto create(@RequestBody CreateUserInfoRequest createUserInfoRequest) {
        return userInfoServiceApi.createUserInfo(createUserInfoRequest);
    }
}
