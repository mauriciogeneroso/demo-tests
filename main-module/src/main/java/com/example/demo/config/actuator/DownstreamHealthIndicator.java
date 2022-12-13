package com.example.demo.config.actuator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
@Component
public class DownstreamHealthIndicator implements HealthIndicator {

    private static final String MESSAGE_KEY = "Downstream";
    private final HttpClient httpClient = HttpClient.newHttpClient();

    @Override
    public Health health() {
        var response = sendRequest();
        if (response != null && response.statusCode() == 200) {
            return Health.up().withDetail(MESSAGE_KEY, "Available").build();
        }

        return Health.down().withDetail(MESSAGE_KEY, "Not Available").build();
    }

    public HttpResponse<String> sendRequest() {
        var builder = HttpRequest.newBuilder();
        builder.uri(buildUri());
        builder.method("GET", bodyPublisher());

        var httpRequest = builder.build();
        try {
            return httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            log.error("Error: {}", e.getMessage());
            return null;
        }
    }

    private URI buildUri() {
        try {
            String finalUri = "http://localhost:9090/downstream/private/health";
            return new URI(finalUri);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private HttpRequest.BodyPublisher bodyPublisher() {
        return HttpRequest.BodyPublishers.noBody();
    }
}