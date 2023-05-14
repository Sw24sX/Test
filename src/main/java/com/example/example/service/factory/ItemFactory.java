package com.example.example.service.factory;

import com.example.example.domain.entity.Item;
import com.example.example.service.dto.request.CreateItemRequest;
import com.example.example.service.dto.request.UpdateItemRequest;
import com.example.example.service.dto.response.ItemDto;

public class ItemFactory {

    public static Item from(CreateItemRequest request) {
        if (request == null) {
            return null;
        }

        var result = new Item();
        result.setName(request.getName());
        result.setCost(request.getCost());
        return result;
    }

    public static Item update(Item item, UpdateItemRequest updateItemRequest) {
        item.setName(updateItemRequest.getName());
        item.setCost(updateItemRequest.getCost());
        return item;
    }

    public static ItemDto to(Item item) {
        if (item == null) {
            return null;
        }

        return new ItemDto(
                item.getId(),
                item.getName(),
                item.getShop().getId(),
                item.getCost()
        );
    }
}
