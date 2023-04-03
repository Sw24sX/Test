package com.example.example.service;

import com.example.example.service.dto.request.CreateUserInfoRequest;
import com.example.example.service.dto.response.UserInfoDto;

/**
 * Сервис для управления пользователем
 */
public interface UserInfoServiceApi {

    /**
     * Получить информацию о пользователе по его id
     * @param id id пользователя
     * @return Информация о пользователе
     */
    UserInfoDto getUserInfoById(Long id);

    /**
     * Создать нового пользователя
     * @param request Параметры для создания нового пользователя
     * @return Информация о созданном пользователе
     */

    UserInfoDto createUserInfo(CreateUserInfoRequest request);
}
