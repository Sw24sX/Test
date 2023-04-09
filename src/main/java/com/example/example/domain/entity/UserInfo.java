package com.example.example.domain.entity;

import com.example.example.domain.enums.RoleType;
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

    private String login;

    private String password;

    @ManyToMany
    @JoinTable(name = "user_info_item",
            joinColumns = @JoinColumn(name = "user_info_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_info_role", joinColumns = @JoinColumn(name = "user_info_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    private List<RoleType> roles;
}
