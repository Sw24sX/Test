package com.example.example.domain;

import com.example.example.domain.entity.Item;
import com.example.example.domain.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByShop(Shop shop);
}
