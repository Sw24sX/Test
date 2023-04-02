package com.example.example.controller;

import com.example.example.service.ShopServiceApi;
import com.example.example.service.dto.request.CreateShopRequest;
import com.example.example.service.dto.response.ShopDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("shop")
@RequiredArgsConstructor
public class ShopController {

    private final ShopServiceApi shopServiceApi;

    @GetMapping
    private ShopDto getById(@RequestParam("shop_id") Long id) {
        return shopServiceApi.getShopById(id);
    }

    @PostMapping
    private ShopDto create(@RequestBody CreateShopRequest request) {
        return shopServiceApi.createShop(request);
    }
}