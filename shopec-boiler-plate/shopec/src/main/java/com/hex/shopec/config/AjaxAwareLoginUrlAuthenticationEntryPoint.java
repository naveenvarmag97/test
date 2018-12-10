package com.hex.shopec.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.ELRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
// CHECKSTYLE:OFF
/**
 * class.
 */
public class AjaxAwareLoginUrlAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {

    private static final RequestMatcher requestMatcher = new ELRequestMatcher(
            "hasHeader('X-Requested-With','XMLHttpRequest')");

    /**
     * class.
     * @param loginFormUrl variable.
     */
    public AjaxAwareLoginUrlAuthenticationEntryPoint(final String loginFormUrl) {
        super(loginFormUrl);

    }

    /**
     * Checks if this is a X-domain pre-flight request.
     *
     * @param request,response,authException variables.
     */
    @Override
    public void commence(final HttpServletRequest request, final HttpServletResponse response,
            final AuthenticationException authException) throws IOException, ServletException {

        if (isPreflight(request)) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } else if (isRestRequest(request)) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        } else {
            super.commence(request, response, authException);
        }
    }

    /**
     * Checks if this is a X-domain pre-flight request.
     *
     * @param request variable.
     * @return options.
     */
    private boolean isPreflight(final HttpServletRequest request) {
        return "OPTIONS".equals(request.getMethod());
    }

    /**
     * Checks if it is a rest request.
     *
     * @param request variable.
     * @return boolean.
     */
    protected final boolean isRestRequest(final HttpServletRequest request) {

        return requestMatcher.matches(request);
    }
}
