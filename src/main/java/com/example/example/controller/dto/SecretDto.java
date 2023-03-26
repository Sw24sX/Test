package com.example.example.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class SecretDto extends BaseDto {

    private static final String TYPE = "super secret";

    private Boolean isItNeed;

    @Override
    public String getType() {
        return TYPE;
    }
}
