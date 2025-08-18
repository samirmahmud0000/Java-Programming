package dev.secureedge.edge;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Adds strict, modern security headers.
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 15)
public class SecurityHeadersFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletResponse res = (HttpServletResponse) response;

    res.setHeader("Strict-Transport-Security", "max-age=31536000; includeSubDomains; preload");
        
    res.setHeader("Content-Security-Policy",
      "default-src 'self'; " +
      "script-src 'self'; " +
      "style-src 'self'; " +
      "img-src 'self' data:; " +
      "font-src 'self'; " +
      "connect-src 'self'; " +
      "frame-ancestors 'none'; " +
      "base-uri 'self'; form-action 'self'");

    res.setHeader("X-Content-Type-Options", "nosniff");
    res.setHeader("Referrer-Policy", "no-referrer");
    res.setHeader("Permissions-Policy",
      "geolocation=(), microphone=(), camera=(), payment=()");

    chain.doFilter(request, response);
  }
}
