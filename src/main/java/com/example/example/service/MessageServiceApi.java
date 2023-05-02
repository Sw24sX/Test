package com.example.example.service;

import com.example.example.service.dto.message.AbstractMessage;

public interface MessageServiceApi {

    void send(AbstractMessage message);
}
