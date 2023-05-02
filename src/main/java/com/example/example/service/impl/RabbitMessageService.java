package com.example.example.service.impl;

import com.example.example.service.MessageServiceApi;
import com.example.example.service.dto.message.AbstractMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service("rabbitService")
@RequiredArgsConstructor
public class RabbitMessageService implements MessageServiceApi {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void send(AbstractMessage message) {
        rabbitTemplate.convertAndSend("test", "rk-example",message);
    }
}
