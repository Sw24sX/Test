package com.example.example.service;

import com.example.example.service.dto.request.CreateShopRequest;
import com.example.example.service.dto.response.ShopDto;

public interface ShopServiceApi {

    ShopDto createShop(CreateShopRequest request);
    ShopDto getShopById(Long id);
}
