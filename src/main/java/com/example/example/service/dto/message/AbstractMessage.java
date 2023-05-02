package com.example.example.service.dto.message;

import lombok.Data;

import java.util.UUID;

@Data
public abstract class AbstractMessage {

    private UUID id = UUID.randomUUID();
}
