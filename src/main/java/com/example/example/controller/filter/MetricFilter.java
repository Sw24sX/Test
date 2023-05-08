package com.example.example.controller.filter;

import com.example.example.service.RequestMetricServiceApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class MetricFilter implements Filter {

    private final RequestMetricServiceApi requestMetricServiceApi;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
        var servletResponse = (HttpServletResponse) response;
        log.info("Response status: {}", servletResponse.getStatus());
        requestMetricServiceApi.increaseStatus(servletResponse.getStatus());
    }
}
