package dev.secureedge.edge;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Simple in-memory sliding-window IP rate limiter.
 * Default: 100 requests / 600 seconds per IP.
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 10)
public class RateLimitingFilter implements Filter {
  private static final Logger log = LoggerFactory.getLogger(RateLimitingFilter.class);

  private final Map<String, ArrayDeque<Long>> hits = new ConcurrentHashMap<>();
  private final int maxReq;
  private final long windowMillis;

  public RateLimitingFilter() {
    this(100, 600_000L);
  }

  public RateLimitingFilter(int maxReq, long windowMillis) {
    this.maxReq = maxReq;
    this.windowMillis = windowMillis;
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;

    String path = req.getRequestURI();
    if (path.startsWith("/health") || path.startsWith("/public/")) {
      chain.doFilter(request, response);
      return;
    }

    String ip = IpUtils.clientIp(req);
    long now = Instant.now().toEpochMilli();

    var q = hits.computeIfAbsent(ip, k -> new ArrayDeque<>());
    synchronized (q) {
    
      long cutoff = now - windowMillis;
      while (!q.isEmpty() && q.peekFirst() < cutoff) q.pollFirst();
      if (q.size() >= maxReq) {
        res.setStatus(429);
        res.setHeader("Retry-After", "60");
        res.getWriter().write("Too Many Requests");
        log.warn("Rate limit exceeded from ip={} path={}", ip, path);
        return;
      }
      q.addLast(now);
    }
    chain.doFilter(request, response);
  }
}
