package com.example.config.auth;


import com.example.properties.basicauth.BasicAuthProperties;
import com.example.properties.basicauth.SecuredEndpoint;
import com.example.properties.basicauth.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthEntryPoint authEntryPoint;
    private final MeoAccessDeniedHandler meoAccessDeniedHandler;
    private final BasicAuthProperties basicAuthProperties;

    @Autowired
    public SecurityConfig(AuthEntryPoint authEntryPoint,
                          MeoAccessDeniedHandler meoAccessDeniedHandler,
                          BasicAuthProperties basicAuthProperties) {
        this.authEntryPoint = authEntryPoint;
        this.meoAccessDeniedHandler = meoAccessDeniedHandler;
        this.basicAuthProperties = basicAuthProperties;
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().regexMatchers(basicAuthProperties.getUnsecuredEndpointPattern());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        for (SecuredEndpoint securedEndpoint : basicAuthProperties.getSecuredEndpoints()) {
            http.authorizeRequests()
                    .mvcMatchers(securedEndpoint.getUrlPattern()).hasRole(securedEndpoint.getRole())
                    .and()
                    .exceptionHandling().accessDeniedHandler(meoAccessDeniedHandler)
                    .and()
                    .httpBasic()
                    .authenticationEntryPoint(authEntryPoint);
        }
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, PasswordEncoder passwordEncoder) throws Exception {
        for (User user : basicAuthProperties.getUsers()) {
            auth.inMemoryAuthentication()
                    .withUser(user.getUsername())
                    .password(passwordEncoder.encode(user.getPassword()))
                    .roles(user.getRole());
        }
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4 , new SecureRandom());
    }
}
