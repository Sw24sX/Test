package com.example.example.service.factory;

import com.example.example.domain.entity.UserInfo;
import com.example.example.service.dto.request.CreateUserInfoRequest;
import com.example.example.service.dto.response.UserInfoDto;

public class UserInfoFactory {

    public static UserInfoDto from(UserInfo userInfo) {
        if (userInfo == null) {
            return null;
        }

        return new UserInfoDto(
                userInfo.getId(),
                userInfo.getName(),
                userInfo.getSurname()
        );
    }

    public static UserInfo to(CreateUserInfoRequest request) {
        if (request == null) {
            return null;
        }

        var result = new UserInfo();
        result.setName(request.getName());
        result.setSurname(request.getSurname());

        return result;
    }
}