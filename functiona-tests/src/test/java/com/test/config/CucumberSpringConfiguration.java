package com.test.config;

import com.test.YamlFileApplicationContextInitializer;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {
        TestConfiguration.class,
        LocalIdentityService.class
},
        initializers = YamlFileApplicationContextInitializer.class)
@CucumberContextConfiguration
public class CucumberSpringConfiguration {
}