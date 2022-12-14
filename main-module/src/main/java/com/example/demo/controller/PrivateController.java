package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
@RestController
@RequestMapping(path = "private")
public class PrivateController {

    private static final String MESSAGE_KEY = "Downstream";
    private final HttpClient httpClient = HttpClient.newHttpClient();

    @GetMapping("/health")
    public ResponseEntity<Health> healthEndpoint(@RequestHeader("X-SkyInt-RequestId") String requestId) {
        var health = health(requestId);
        if (health.getStatus().equals(Status.UP))
            return ResponseEntity.ok(health);
        else
            return ResponseEntity.status(503).body(health);
    }


    public Health health(String requestId) {
        var response = sendRequest(requestId);
        if (response != null && response.statusCode() == 200) {
            return Health.up().withDetail(MESSAGE_KEY, "Available").build();
        }

        return Health.down().withDetail(MESSAGE_KEY, "Not Available").build();
    }

    public HttpResponse<String> sendRequest(String requestId) {
        var builder = HttpRequest.newBuilder();
        builder.uri(buildUri());
        builder.method("GET", bodyPublisher());
        builder.header("X-SkyInt-RequestId", requestId);

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
