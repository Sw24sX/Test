package com.example.example.service;

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


}
