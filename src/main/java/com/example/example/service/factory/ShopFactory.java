package com.example.example.service.factory;

import com.example.example.domain.entity.Shop;
import com.example.example.service.dto.request.CreateShopRequest;
import com.example.example.service.dto.response.ShopDto;

public class ShopFactory {

    public static Shop from(CreateShopRequest request) {
        if (request == null) {
            return null;
        }

        var result = new Shop();
        result.setName(request.getName());
        return result;
    }

    public static ShopDto to(Shop shop) {
        if (shop == null) {
            return null;
        }

        return new ShopDto(
                shop.getId(),
                shop.getName()
        );
    }
}
