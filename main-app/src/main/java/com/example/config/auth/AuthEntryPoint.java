package com.example.config.auth;

import com.example.exception.GeneralException;
import com.example.web.exception.ErrorDetail;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.http.HttpStatus.FORBIDDEN;

@Component
public class AuthEntryPoint extends BasicAuthenticationEntryPoint {

    private final HandlerExceptionResolver handlerExceptionResolver;

    public AuthEntryPoint(HandlerExceptionResolver handlerExceptionResolver) {
        this.handlerExceptionResolver = handlerExceptionResolver;
        setRealmName("Meo Realm");
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) {

        if (authException != null) {
            handlerExceptionResolver.resolveException(request, response, null,
                    new GeneralException(ErrorDetail.of("OVP_00306", "Security failure", FORBIDDEN)));
        }
    }

}
