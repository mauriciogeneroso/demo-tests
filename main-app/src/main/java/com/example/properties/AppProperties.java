package com.example.properties;

import com.example.ActuatorAppProperties;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
@EnableConfigurationProperties({LoggingProperties.class})
public class AppProperties implements ActuatorAppProperties {

    private LoggingProperties loggingProperties;

    @Autowired
    public AppProperties(LoggingProperties loggingProperties) {
        this.loggingProperties = loggingProperties;
    }

    @Override
    public ActuatorAppProperties create() {
        return this;
    }
}
