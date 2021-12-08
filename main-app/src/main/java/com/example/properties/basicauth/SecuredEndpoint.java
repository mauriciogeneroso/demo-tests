package com.example.properties.basicauth;

public class SecuredEndpoint {

    private String urlPattern;
    private String role;

    public SecuredEndpoint() {
    }

    public SecuredEndpoint(String urlPattern, String role) {
        this.urlPattern = urlPattern;
        this.role = role;
    }

    public String getUrlPattern() {
        return urlPattern;
    }

    public void setUrlPattern(String urlPattern) {
        this.urlPattern = urlPattern;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
