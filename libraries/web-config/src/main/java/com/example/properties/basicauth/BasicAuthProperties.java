package com.example.properties.basicauth;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
@ConfigurationProperties(prefix = "app.basic-auth")
public class BasicAuthProperties {

    private Set<SecuredEndpoint> securedEndpoints = new HashSet<>();;
    private Set<User> users =  new HashSet<>();
    private String unsecuredEndpointPattern;

    public BasicAuthProperties() {
    }

    public BasicAuthProperties(Set<SecuredEndpoint> securedEndpoints, Set<User> users, String unsecuredEndpointPattern) {
        this.securedEndpoints = securedEndpoints;
        this.users = users;
        this.unsecuredEndpointPattern = unsecuredEndpointPattern;
    }

    public Set<SecuredEndpoint> getSecuredEndpoints() {
        return securedEndpoints;
    }

    public void setSecuredEndpoints(Set<SecuredEndpoint> securedEndpoints) {
        this.securedEndpoints = securedEndpoints;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getUnsecuredEndpointPattern() {
        return unsecuredEndpointPattern;
    }

    public void setUnsecuredEndpointPattern(String unsecuredEndpointPattern) {
        this.unsecuredEndpointPattern = unsecuredEndpointPattern;
    }
}
