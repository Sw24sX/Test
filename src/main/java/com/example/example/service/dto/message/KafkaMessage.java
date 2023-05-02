package com.example.example.service.dto.message;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KafkaMessage extends AbstractMessage {

    private String example;

    private boolean test;
}
