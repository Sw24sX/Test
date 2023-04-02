package com.example.example.service;

import com.example.example.service.dto.request.CreateUserInfoRequest;
import com.example.example.service.dto.response.UserInfoDto;

public interface UserInfoServiceApi {

    UserInfoDto getUserInfoById(Long id);

    UserInfoDto createUserInfo(CreateUserInfoRequest request);
}
