package com.example.example.service.impl;

import com.example.example.service.ShopServiceApi;
import com.example.example.service.dto.request.CreateShopRequest;
import com.example.example.service.dto.response.ShopDto;
import org.springframework.stereotype.Service;

@Service
public class ShopService implements ShopServiceApi {
    @Override
    public ShopDto createShop(CreateShopRequest request) {
        return null;
    }

    @Override
    public ShopDto getShopById(Long id) {
        return null;
    }
}
