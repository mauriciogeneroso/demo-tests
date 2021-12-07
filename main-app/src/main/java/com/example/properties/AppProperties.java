package com.example.properties;

import com.example.config.actuator.ActuatorAppProperties;
import org.springframework.stereotype.Component;

@Component
public class AppProperties implements ActuatorAppProperties {

    private LoggingProperties loggingProperties;
    private CassandraProperties cassandraProperties;

    public AppProperties(LoggingProperties loggingProperties, CassandraProperties cassandraProperties) {
        this.loggingProperties = loggingProperties;
        this.cassandraProperties = cassandraProperties;
    }

    @Override
    public ActuatorAppProperties create() {
        return new AppProperties(new LoggingProperties(loggingProperties.getEncryptionFields()),
                new CassandraProperties(cassandraProperties));
    }

    public LoggingProperties getLoggingProperties() {
        return loggingProperties;
    }

    public CassandraProperties getCassandraProperties() {
        return cassandraProperties;
    }
}
