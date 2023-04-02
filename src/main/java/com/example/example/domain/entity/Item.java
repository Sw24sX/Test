package com.example.example.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Item extends BaseEntity {

    private String name;

    private Double cost;

    @ManyToMany(mappedBy = "items")
    private List<UserInfo> userInfoList;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;
}
