package com.example.example.service.impl;

import com.example.example.service.RequestMetricServiceApi;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequestMetricService implements RequestMetricServiceApi {

    private final MeterRegistry registry;

    @Override
    public void increaseStatus(int httpStatus) {
        var counterName = String.format("counter.status.%s", httpStatus);
        registry.counter(counterName).increment(1);
    }
}
