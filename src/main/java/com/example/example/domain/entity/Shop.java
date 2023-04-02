package com.example.example.domain.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table
public class Shop extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "shop")
    private List<Item> items;
}
