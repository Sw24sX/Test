package com.example.example.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@RequiredArgsConstructor
public class UserInfo extends BaseEntity {

    private String name;

    private String surname;

    @ManyToMany
    @JoinTable(
            name = "user_info_item",
            joinColumns = @JoinColumn(name = "user_info_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> items;
}
