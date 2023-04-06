package com.example.example.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Shop extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "shop")
    private List<Item> items;
}
