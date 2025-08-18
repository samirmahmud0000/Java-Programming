package dev.secureedge.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  SecurityFilterChain httpSecurity(HttpSecurity http) throws Exception {
    http
      .cors(cors -> cors.configurationSource(CorsPolicies.strict()))
      .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
      .csrf(csrf -> csrf.disable())
      .headers(h -> h
        .xssProtection(x -> x.block(true))
        .frameOptions(HeadersConfigurer.FrameOptionsConfig::deny)
      )
      .authorizeHttpRequests(reg -> reg
        .requestMatchers(HttpMethod.GET, "/health").permitAll()
        .requestMatchers("/public/**").permitAll()
        .requestMatchers("/admin/**").authenticated()
        .anyRequest().permitAll()
      )
      .httpBasic(Customizer.withDefaults());

    return http.build();
  }
  
  @Bean
  UserDetailsService users() {
    return new InMemoryUserDetailsManager(
      User.withUsername("admin")
          .password("{noop}changeme")
          .roles("ADMIN")
          .build()
    );
  }
}
