package com.example.example.controller;

import com.example.example.service.UserInfoServiceApi;
import com.example.example.service.dto.response.UserInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user-info")
@RequiredArgsConstructor
public class UserInfoController {

    private final UserInfoServiceApi userInfoServiceApi;

    @GetMapping
    public UserInfoDto getById(@RequestParam("user_id") Long id) {
        return userInfoServiceApi.getUserInfoById(id);
    }
}
