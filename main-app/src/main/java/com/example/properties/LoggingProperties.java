package com.example.properties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ConfigurationProperties(prefix = "ovp.logging")
public class LoggingProperties {

    @JsonIgnore
    private Map<String, String> encryptionFields = new HashMap<>();
}

