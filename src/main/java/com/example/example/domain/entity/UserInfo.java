package com.example.example.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class UserInfo extends BaseEntity {

    private String name;

    private String surname;

    @ManyToMany
    @JoinTable(name = "user_info_item",
            joinColumns = @JoinColumn(name = "user_info_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items;
}
