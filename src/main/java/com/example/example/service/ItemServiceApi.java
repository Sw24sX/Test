package com.example.example.service;

import com.example.example.service.dto.request.AddItemToShoppingCartRequest;
import com.example.example.service.dto.request.CreateItemRequest;
import com.example.example.service.dto.response.ItemDto;

import java.util.List;

public interface ItemServiceApi {

    ItemDto createItem(CreateItemRequest request);

    ItemDto addItemToShoppingCart(AddItemToShoppingCartRequest request);

    List<ItemDto> userInfoShoppingCart(Long userInfo);

    ItemDto getItemById(Long id);
}
