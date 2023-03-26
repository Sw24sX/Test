package com.example.example.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class PrivateDto extends BaseDto {

    private static final String TYPE = "private";

    private Integer secret;

    @Override
    public String getType() {
        return TYPE;
    }
}
