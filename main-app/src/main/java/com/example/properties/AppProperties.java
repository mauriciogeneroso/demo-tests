package com.example.properties;

import com.example.config.actuator.ActuatorAppProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Builder(toBuilder = true)
@Configuration
@Component
@ConfigurationProperties(prefix = "app")
@EnableConfigurationProperties({LoggingProperties.class, CassandraProperties.class})
public class AppProperties implements ActuatorAppProperties {

    public LoggingProperties loggingProperties;
    public CassandraProperties cassandraProperties;

    @Override
    public ActuatorAppProperties create() {
        return this;
    }
}
