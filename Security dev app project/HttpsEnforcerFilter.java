package dev.secureedge.edge;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Redirects HTTP to HTTPS, aware reverseas project
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 5)
public class HttpsEnforcerFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;

    boolean secure = req.isSecure();
    String xfProto = req.getHeader("X-Forwarded-Proto");
    boolean forwardedHttps = xfProto != null && xfProto.equalsIgnoreCase("https");

    if (!secure && !forwardedHttps) {
      String host = req.getHeader("Host");
      String url = "https://" + (host != null ? host : req.getServerName()) + req.getRequestURI();
      String qs = req.getQueryString();
      if (qs != null && !qs.isBlank()) url += "?" + qs;
      res.setStatus(301);
      res.setHeader("Location", url);
      return;
    }
    chain.doFilter(request, response);
  }
}
