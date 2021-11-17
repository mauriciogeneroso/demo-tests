package com.example.demo.config.filters;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class XClacksOverhead implements Filter {

    public static final String X_CLACKS_OVERHEAD = "X-Clacks-Overhead";

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        var response = (HttpServletResponse) res;
        response.setHeader(X_CLACKS_OVERHEAD, "GNU Terry Pratchett");
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }
}