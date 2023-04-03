package com.example.example.service.impl;

import com.example.example.service.ItemServiceApi;
import com.example.example.service.dto.request.AddItemToShoppingCartRequest;
import com.example.example.service.dto.request.CreateItemRequest;
import com.example.example.service.dto.response.ItemDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService implements ItemServiceApi {
    @Override
    public ItemDto createItem(CreateItemRequest request) {
        return null;
    }

    @Override
    public ItemDto addItemToShoppingCart(AddItemToShoppingCartRequest request) {
        return null;
    }

    @Override
    public List<ItemDto> userInfoShoppingCart(Long userInfo) {
        return null;
    }

    @Override
    public ItemDto getItemById(Long id) {
        return null;
    }
}
