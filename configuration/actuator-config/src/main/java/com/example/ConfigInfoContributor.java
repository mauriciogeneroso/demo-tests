package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ConfigInfoContributor implements InfoContributor {

    @Value("${DEPLOYMENT_ENVIRONMENT:dev}")
    private String deploymentEnvironment;

    @Autowired
    private ActuatorAppProperties actuatorAppProperties;

    @Override
    public void contribute(Info.Builder builder) {
        //log.info("Including details to InfoContributor");
        builder.withDetail("environment", deploymentEnvironment);
        builder.withDetail("configuration", actuatorAppProperties.create());
    }
}