package dev.secureedge.edge;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Set;

/**
 * Basic IP allow/deny lists. Use CIDR lib for advanced ranges if needed.
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 20)
public class IpAllowDenyFilter implements Filter {

  private final Set<String> deny = Set.of(
    "185.XX.XX.10",
    "203.0.113.7"
  );

  private final Set<String> allow = Set.of(
   
  );

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;

    String ip = IpUtils.clientIp(req);
    String path = req.getRequestURI();

    if (deny.contains(ip)) {
      res.setStatus(403);
      res.getWriter().write("Forbidden");
      return;
    }
    if (path.startsWith("/admin/") && !allow.isEmpty() && !allow.contains(ip)) {
      res.setStatus(403);
      res.getWriter().write("Forbidden");
      return;
    }

    chain.doFilter(request, response);
  }
}
