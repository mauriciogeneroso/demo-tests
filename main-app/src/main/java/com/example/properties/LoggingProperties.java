package com.example.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;


@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "app.cassandra.meo")
public class LoggingProperties {

    private Map<String, String> encryptionFields;
}

