package com.example.example.service.dto.message;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RabbitMessage extends AbstractMessage {

    private String text;

    private Integer number;
}
