package com.example.example.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Item extends BaseEntity {

    private String name;
    private Integer cost;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @ManyToMany(mappedBy = "items")
    private List<UserInfo> userInfoList;
}
