package com.example.example.service;

import com.example.example.service.dto.actuator.CounterDto;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "example")
public class ExampleActuator {

    @ReadOperation
    public CounterDto example() {

        return new CounterDto("ok");
    }
}
