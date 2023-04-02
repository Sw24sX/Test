package com.example.example.controller;

import com.example.example.service.ItemServiceApi;
import com.example.example.service.dto.request.AddItemToShoppingCartRequest;
import com.example.example.service.dto.request.CreateItemRequest;
import com.example.example.service.dto.response.ItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("item")
@RequiredArgsConstructor
@Validated
public class ItemController {

    private final ItemServiceApi itemServiceApi;

    @GetMapping("shopping-cart/list")
    public List<ItemDto> shoppingCartItems(@RequestParam("user_info_id") Long userInfoId) {
        return itemServiceApi.userInfoShoppingCart(userInfoId);
    }

    @PostMapping
    public ItemDto create(@Valid @RequestBody CreateItemRequest createItemRequest) {
        return itemServiceApi.createItem(createItemRequest);
    }

    @PostMapping("shopping-cart/add")
    public ItemDto addToShoppingCart(@Valid @RequestBody AddItemToShoppingCartRequest addItemToShoppingCartRequest) {
        return itemServiceApi.addItemToShoppingCart(addItemToShoppingCartRequest);
    }

    @GetMapping
    public ItemDto getById(@RequestParam("item_id") Long id) {
        return itemServiceApi.getItemById(id);
    }
}
