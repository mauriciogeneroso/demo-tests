package com.example.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "app.ovp.logging")
public class LoggingProperties {

    private Map<String, String> encryptionFields;

    public LoggingProperties(Map<String, String> encryptionFields) {
        this.encryptionFields = encryptionFields;
    }

    public Map<String, String> getEncryptionFields() {
        return encryptionFields;
    }

    public void setEncryptionFields(Map<String, String> encryptionFields) {
        this.encryptionFields = encryptionFields;
    }
}

