package com.example.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "cassandra")
public class CassandraProperties {
    private String keyspace;
    private String contactPoints;
    private int port;
    private String username;
    private String password;
    long waitInterval;
    private int connectTimeout;
    private int readTimeout;
    private String cqlMigrateDirectory;
    private boolean skipMigration;
    private boolean active;
}
