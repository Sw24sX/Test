package com.example.example.service.impl;

import com.example.example.service.MessageServiceApi;
import com.example.example.service.dto.message.AbstractMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service("kafkaService")
@RequiredArgsConstructor
public class KafkaMessageService implements MessageServiceApi {

    private final KafkaTemplate<String, AbstractMessage> kafkaTemplate;

    @Override
    public void send(AbstractMessage message) {
        kafkaTemplate.send("test.topic", message);
    }
}
