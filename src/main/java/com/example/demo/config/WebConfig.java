package com.example.demo.config;

import com.example.demo.config.filters.LogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

// https://stackoverflow.com/questions/19825946/how-can-i-add-a-filter-class-in-spring-boot
@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean<LogFilter> logFilter() {
        var filterRegistrationBean = new FilterRegistrationBean<>(new LogFilter());
        filterRegistrationBean.setUrlPatterns(List.of("/hello"));
//        filterRegistrationBean.setUrlPatterns(List.of("/hello/*"));
        return filterRegistrationBean;
    }

}
