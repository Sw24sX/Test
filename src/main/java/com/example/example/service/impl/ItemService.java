package com.example.example.service.impl;

import com.example.example.domain.ItemRepository;
import com.example.example.domain.ShopRepository;
import com.example.example.domain.UserInfoRepository;
import com.example.example.service.ItemServiceApi;
import com.example.example.service.dto.request.AddItemToShoppingCartRequest;
import com.example.example.service.dto.request.CreateItemRequest;
import com.example.example.service.dto.response.ItemDto;
import com.example.example.service.exception.NotFoundException;
import com.example.example.service.factory.ItemFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService implements ItemServiceApi {

    private final ItemRepository itemRepository;
    private final ShopRepository shopRepository;
    private final UserInfoRepository userInfoRepository;

    @Override
    public ItemDto createItem(CreateItemRequest request) {
        var item = ItemFactory.to(request);
        var shop = shopRepository
                .findById(request.getShopId())
                .orElseThrow(() -> new NotFoundException("Shop with id %s not found", request.getShopId().toString()));
        item.setShop(shop);
        var result = itemRepository.save(item);
        return ItemFactory.from(result);
    }

    @Override
    public ItemDto addItemToShoppingCart(AddItemToShoppingCartRequest request) {
        var user = userInfoRepository.findById(request.getUserInfoId())
                .orElseThrow(() -> new NotFoundException("User not found by id %s", request.getUserInfoId().toString()));
        var item = itemRepository
                .findById(request.getItemId())
                .orElseThrow(() -> new NotFoundException("Item not found by id %s", request.getItemId().toString()));
        user.getItems().add(item);
        userInfoRepository.save(user);
        return ItemFactory.from(item);
    }

    @Override
    public List<ItemDto> userInfoShoppingCart(Long userInfoId) {
        var userInfo = userInfoRepository.findById(userInfoId)
                .orElseThrow(() -> new NotFoundException("User not found by id %s", userInfoId.toString()));
        return userInfo.getItems().stream().map(ItemFactory::from).toList();
    }

    @Override
    public ItemDto getItemById(Long id) {
        var result = itemRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Item not found by id %s", id.toString()));
        return ItemFactory.from(result);
    }
}
