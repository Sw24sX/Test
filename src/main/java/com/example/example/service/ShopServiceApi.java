package com.example.example.service;

import com.example.example.service.dto.request.CreateShopRequest;
import com.example.example.service.dto.response.ShopDto;

/**
 * Сервис для управления магазином
 */
public interface ShopServiceApi {

    /**
     * Создание нового магазина
     * @param request Запрос с параметрами для создания магазина
     * @return Созданный магазин
     */
    ShopDto createShop(CreateShopRequest request);

    /**
     * Получить информацию о магазине по id
     * @param id id магазина
     * @return Информация о магазине
     */
    ShopDto getShopById(Long id);
}
