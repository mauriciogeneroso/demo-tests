package com.example.config.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class ConfigInfoContributor implements InfoContributor {

    @Value("${DEPLOYMENT_ENVIRONMENT:dev}")
    private String deploymentEnvironment;

    @Autowired
    private ActuatorAppProperties actuatorAppProperties;

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("environment", deploymentEnvironment);
        builder.withDetail("configuration", actuatorAppProperties.create());
    }
}