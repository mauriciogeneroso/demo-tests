package com.example.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.meo.cassandra")
public class CassandraProperties {

    private String keyspace;
    private String contactPoints;
    private int port;
    private String username;
    private String password;
    private long waitInterval;
    private int connectTimeout;
    private int readTimeout;
    private String cqlMigrateDirectory;
    private boolean skipMigration;
    private boolean active;

    public CassandraProperties() {
    }

    public CassandraProperties(CassandraProperties other) {
        this.keyspace = other.keyspace;
        this.contactPoints = other.contactPoints;
        this.port = other.port;
        this.username = other.username;
        this.password = other.password;
        this.waitInterval = other.waitInterval;
        this.connectTimeout = other.connectTimeout;
        this.readTimeout = other.readTimeout;
        this.cqlMigrateDirectory = other.cqlMigrateDirectory;
        this.skipMigration = other.skipMigration;
        this.active = other.active;
    }

    public String getKeyspace() {
        return keyspace;
    }

    public void setKeyspace(String keyspace) {
        this.keyspace = keyspace;
    }

    public String getContactPoints() {
        return contactPoints;
    }

    public void setContactPoints(String contactPoints) {
        this.contactPoints = contactPoints;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getWaitInterval() {
        return waitInterval;
    }

    public void setWaitInterval(long waitInterval) {
        this.waitInterval = waitInterval;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    public String getCqlMigrateDirectory() {
        return cqlMigrateDirectory;
    }

    public void setCqlMigrateDirectory(String cqlMigrateDirectory) {
        this.cqlMigrateDirectory = cqlMigrateDirectory;
    }

    public boolean isSkipMigration() {
        return skipMigration;
    }

    public void setSkipMigration(boolean skipMigration) {
        this.skipMigration = skipMigration;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
