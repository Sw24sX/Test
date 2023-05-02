package com.example.example.service.impl;

import com.example.example.domain.repository.ItemRepository;
import com.example.example.domain.repository.ShopRepository;
import com.example.example.domain.repository.UserInfoRepository;
import com.example.example.service.ItemServiceApi;
import com.example.example.service.MessageServiceApi;
import com.example.example.service.dto.message.KafkaMessage;
import com.example.example.service.dto.request.AddItemToShoppingCartRequest;
import com.example.example.service.dto.request.CreateItemRequest;
import com.example.example.service.dto.response.ItemDto;
import com.example.example.service.exception.NotFoundException;
import com.example.example.service.factory.ItemFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService implements ItemServiceApi {

    private final ItemRepository itemRepository;
    private final UserInfoRepository userInfoRepository;
    private final ShopRepository shopRepository;
    private final MessageServiceApi kafkaService;

    @Override
    public ItemDto createItem(CreateItemRequest request) {
        var shop = shopRepository.findById(request.getShopId())
                .orElseThrow(() -> new NotFoundException("Shop not found"));
        var item = ItemFactory.from(request);
        item.setShop(shop);
        var result = itemRepository.save(item);
        return ItemFactory.to(result);
    }

    @Override
    public ItemDto addItemToShoppingCart(AddItemToShoppingCartRequest request) {
        var item = itemRepository.findById(request.getItemId())
                .orElseThrow(() -> new NotFoundException("Item not found by id %s", request.getItemId()));
        var user = userInfoRepository.findById(request.getUserInfoId())
                .orElseThrow(() -> new NotFoundException("User not found"));
        user.getItems().add(item);
        userInfoRepository.save(user);
        return ItemFactory.to(item);
    }

    @Override
    public List<ItemDto> userInfoShoppingCart(Long userInfo) {
        var user = userInfoRepository.findById(userInfo)
                .orElseThrow(() -> new NotFoundException("User not found"));
        return user.getItems().stream().map(ItemFactory::to).toList();
    }

    @Override
    public ItemDto getItemById(Long id) {
        kafkaService.send(new KafkaMessage("example", true));
        var item = itemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Item not found by id %s", id));

        return ItemFactory.to(item);
    }

    @Override
    public List<ItemDto> getItemsByUserAndShop(Long userId, Long shopId) {
        var shop = shopRepository.findById(shopId)
                .orElseThrow(() -> new NotFoundException("Shop not found"));
        var result = itemRepository.findByShop(shop);
        return result.stream().map(ItemFactory::to).toList();
    }
}
