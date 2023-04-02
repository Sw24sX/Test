package com.example.example.service.factory;

import com.example.example.domain.entity.Item;
import com.example.example.service.dto.request.CreateItemRequest;
import com.example.example.service.dto.response.ItemDto;

public class ItemFactory {

    public static ItemDto from(Item item) {
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

    public static Item to(CreateItemRequest request) {
        if (request == null) {
            return null;
        }

        var result = new Item();
        result.setCost(request.getCost());
        result.setName(request.getName());
        return result;
    }
}
