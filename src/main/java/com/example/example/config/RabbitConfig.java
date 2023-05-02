package com.example.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

@Profile("rabbit")
@Configuration
public class RabbitConfig {

    @Bean
    public MappingJackson2MessageConverter jackson2Converter() {
        return new MappingJackson2MessageConverter();
    }

    @Bean
    public RabbitTemplate jsonRabbitTemplate(ConnectionFactory connectionFactory, ObjectMapper mapper) {
        final var jsonRabbitTemplate = new RabbitTemplate(connectionFactory);
        jsonRabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter(mapper));
        return jsonRabbitTemplate;
    }
}
