package com.example.example.service.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddItemToShoppingCartRequest {

    @NotNull
    private Long userInfoId;

    @NotNull
    private Long itemId;
}
