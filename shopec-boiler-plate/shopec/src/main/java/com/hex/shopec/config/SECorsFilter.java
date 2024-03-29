package com.hex.shopec.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
// CHECKSTYLE:OFF
/*
Component
*/
@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
public class SECorsFilter implements Filter {

    /*
    Component.
    */
    public SECorsFilter() {
        super();
    }

    @Override
    public final void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain)
            throws IOException, ServletException {
        final HttpServletResponse response = (HttpServletResponse) res;
        /*response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        // without this header jquery.ajax calls returns 401 even after successful login
        //and SSESSIONID being succesfully stored.
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers",
        "X-Requested-With, Authorization, Origin, Content-Type, Version");
        response.setHeader("Access-Control-Expose-Headers", "X-Requested-With,
        Authorization, Origin, Content-Type");
        */

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET,HEAD,OPTIONS,POST,PUT");
        response.setHeader("Access-Control-Allow-Headers",
                "Access-Control-Allow-Headers, Authorization, Origin,Accept, X-Requested-With,Content-Type"
                        + "Access-Control-Request-Method, Access-Control-Request-Headers");
        response.addHeader("WWW-Authenticate", "Basic realm=hhh");
        final HttpServletRequest request = (HttpServletRequest) req;
        if (!request.getMethod().equals("OPTIONS")) {
            chain.doFilter(req, res);
        } else {
            // do not continue with filter chain for options requests
        }
    }

    @Override
    public void destroy() {
        //destroy
    }

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
    }
}