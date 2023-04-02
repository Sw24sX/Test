package com.example.example.service.impl;

import com.example.example.domain.ShopRepository;
import com.example.example.service.ShopServiceApi;
import com.example.example.service.dto.request.CreateShopRequest;
import com.example.example.service.dto.response.ShopDto;
import com.example.example.service.exception.NotFoundException;
import com.example.example.service.factory.ShopFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShopService implements ShopServiceApi {

    private final ShopRepository shopRepository;

    @Override
    public ShopDto createShop(CreateShopRequest request) {
        var shop = ShopFactory.to(request);
        var result = shopRepository.save(shop);
        return ShopFactory.from(result);
    }

    @Override
    public ShopDto getShopById(Long id) {
        var result = shopRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Shop not found by id %s", id.toString()));
        return ShopFactory.from(result);
    }
}
