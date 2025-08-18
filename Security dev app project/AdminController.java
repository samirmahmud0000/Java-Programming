package dev.secureedge.web;

import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admin")
@Validated
public class AdminController {

  @PostMapping("/announce")
  public Map<String, String> announce(
      @RequestParam @NotBlank String message) {
    return Map.of("ok", "true", "message", message);
  }
}
