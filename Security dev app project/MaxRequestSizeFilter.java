package dev.secureedge.edge;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Hard caps request size at the edge to reduce abuse.
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 25)
public class MaxRequestSizeFilter implements Filter {

  private static final long MAX_BYTES = 2L * 1024L * 1024L;

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;

    long contentLength = req.getContentLengthLong();
    if (contentLength > 0 && contentLength > MAX_BYTES) {
      res.setStatus(413);
      res.getWriter().write("Payload Too Large");
      return;
    }
    chain.doFilter(request, response);
  }
}
