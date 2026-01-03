package com.mercor.objectstore.config;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

@Component
public class MetricsInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(MetricsInterceptor.class);
    private final MeterRegistry meterRegistry;
    private final Timer requestTimer;

    public MetricsInterceptor(MeterRegistry registry) {
        this.meterRegistry = registry;

        this.requestTimer = Timer.builder("http.request.duration")
                .description("HTTP request latency")
                .tag("application", "objectstore")
                .publishPercentiles(0.5, 0.95, 0.99)
                .register(registry);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        Long startTime = (Long) request.getAttribute("startTime");
        if (startTime != null) {
            long duration = System.currentTimeMillis() - startTime;
            
            String method = request.getMethod();
            String uri = sanitizeUri(request.getRequestURI());
            String status = String.valueOf(response.getStatus());

            // Record request count with tags
            Counter.builder("http.requests.total")
                    .description("Total number of HTTP requests")
                    .tag("application", "objectstore")
                    .tag("method", method)
                    .tag("uri", uri)
                    .tag("status", status)
                    .register(meterRegistry)
                    .increment();

            // Record request latency
            requestTimer.record(duration, TimeUnit.MILLISECONDS);

            // Record errors (4xx and 5xx status codes)
            if (response.getStatus() >= 400) {
                Counter.builder("http.requests.errors")
                        .description("Total number of HTTP errors")
                        .tag("application", "objectstore")
                        .tag("method", method)
                        .tag("uri", uri)
                        .tag("status", status)
                        .register(meterRegistry)
                        .increment();
            }

            logger.debug("Request {} {} took {}ms, status: {}", 
                request.getMethod(), 
                request.getRequestURI(), 
                duration, 
                response.getStatus());
        }
    }

    private String sanitizeUri(String uri) {
        // Replace path variables with placeholders for better metric aggregation
        if (uri.startsWith("/api/objects/") && uri.length() > "/api/objects/".length()) {
            return "/api/objects/{key}";
        }
        return uri;
    }
}

