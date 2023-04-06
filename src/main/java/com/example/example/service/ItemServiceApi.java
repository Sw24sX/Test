package com.example.example.service;

import com.example.example.service.dto.request.AddItemToShoppingCartRequest;
import com.example.example.service.dto.request.CreateItemRequest;
import com.example.example.service.dto.response.ItemDto;

import java.util.List;

/**
 * Сервис для управления предметами для покупок
 */
public interface ItemServiceApi {

    /**
     * Создание предмета для покупки
     * @param request Параметры предмета
     * @return Созданный предмет
     */
    ItemDto createItem(CreateItemRequest request);

    /**
     * Добавить предмет в корзину покупок пользователя
     * @param request Параметры для добавления предмета в корзину
     * @return Добавленный предмет
     */
    ItemDto addItemToShoppingCart(AddItemToShoppingCartRequest request);

    /**
     * Список предметов в корзине покупок пользователя
     * @param userInfo id пользователя
     * @return Список предметов
     */
    List<ItemDto> userInfoShoppingCart(Long userInfo);

    /**
     * Получить описание предмета по id
     * @param id id предмета
     * @return Описание предмета
     */
    ItemDto getItemById(Long id);

    /**
     *
     * @param userId
     * @param shopId
     * @return
     */
    List<ItemDto> getItemsByUserAndShop(Long userId, Long shopId);
}
