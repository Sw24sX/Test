package com.example.example.service.impl;

import com.example.example.service.MessageServiceApi;
import com.example.example.service.dto.message.AbstractMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service("amqService")
@RequiredArgsConstructor
public class AmqMessageService implements MessageServiceApi {

    private final JmsTemplate jmsTemplate;

    @Override
    public void send(AbstractMessage message) {
        jmsTemplate.convertAndSend("test.queue", message);
    }
}
