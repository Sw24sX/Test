package com.example.example.service.dto.message;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AmqMessage extends AbstractMessage {

    private String message;
}
