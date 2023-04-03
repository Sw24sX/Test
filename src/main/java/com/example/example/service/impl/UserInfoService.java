package com.example.example.service.impl;

import com.example.example.service.UserInfoServiceApi;
import com.example.example.service.dto.request.CreateUserInfoRequest;
import com.example.example.service.dto.response.UserInfoDto;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService implements UserInfoServiceApi {
    @Override
    public UserInfoDto getUserInfoById(Long id) {
        return null;
    }

    @Override
    public UserInfoDto createUserInfo(CreateUserInfoRequest request) {
        return null;
    }
}
