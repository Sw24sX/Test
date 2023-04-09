package com.example.example.domain.repository;

import com.example.example.domain.entity.Item;
import com.example.example.domain.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByShop(Shop shop);
}
