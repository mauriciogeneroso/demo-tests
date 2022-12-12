package com.test.client.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public enum Endpoint {

    PRIVATE_INFO("/private/info", "GET"),
    PRIVATE_HEALTH_CHECK("/private/health", "GET");

    private final String path;
    private final String method;;
}