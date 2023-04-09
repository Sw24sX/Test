package com.example.example.service;

import com.example.example.service.dto.request.CreateUserInfoRequest;
import com.example.example.service.dto.response.UserInfoDto;

public interface AuthServiceApi {

    /**
     * Регистрация нового пользователя
     * @param request Параметры для создания нового пользователя
     * @return Информация о созданном пользователе
     */
    UserInfoDto registerUser(CreateUserInfoRequest request);

    /**
     * Авторизация пользователя
     * @return информация об авторизованном пользователе
     */
    UserInfoDto login(String username);
}
