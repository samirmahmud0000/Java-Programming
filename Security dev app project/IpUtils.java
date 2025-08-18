package dev.secureedge.edge;

import jakarta.servlet.http.HttpServletRequest;

public final class IpUtils {
  private IpUtils() {}

  public static String clientIp(HttpServletRequest req) {
    String[] hdrs = {
      "X-Forwarded-For",
      "X-Real-IP",
      "CF-Connecting-IP"
    };
    for (String h : hdrs) {
      String v = req.getHeader(h);
      if (v != null && !v.isBlank()) {
        String first = v.split(",")[0].trim();
        if (!first.isBlank()) return first;
      }
    }
    return req.getRemoteAddr();
  }
}
