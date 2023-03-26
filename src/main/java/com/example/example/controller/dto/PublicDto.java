package com.example.example.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class PublicDto extends BaseDto {

    private static final String TYPE = "public";

    private String someProperty;

    @Override
    public String getType() {
        return TYPE;
    }
}
