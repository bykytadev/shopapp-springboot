package com.project.shopapp.configurations;

import com.project.shopapp.filters.JwtTokenFilter;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.security.reactive.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity(debug = false)
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
@RequiredArgsConstructor
public class WebSecurityConfig extends GlobalMethodSecurityConfiguration {
        private final JwtTokenFilter jwtTokenFilter;
        @Value("${api.prefix}")
        private String apiPrefix;

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
                                .authorizeHttpRequests(requests -> {
                                        requests
                                                        .requestMatchers(
                                                                        String.format("%s/users/register", apiPrefix),
                                                                        String.format("%s/users/login", apiPrefix),
                                                                        // healthcheck
                                                                        String.format("%s/healthcheck/**", apiPrefix),
                                                                        String.format("%s/healthcheck/health", apiPrefix), // Add this line

                                                                        // swagger
                                                                        // "/v3/api-docs",
                                                                        // "/v3/api-docs/**",
                                                                        "/api-docs",
                                                                        "/api-docs/**",
                                                                        "/swagger-resources",
                                                                        "/swagger-resources/**",
                                                                        "/configuration/ui",
                                                                        "/configuration/security",
                                                                        "/swagger-ui/**",
                                                                        "/swagger-ui.html",
                                                                        "/webjars/swagger-ui/**",
                                                                        "/swagger-ui/index.html"

                                                        )
                                                        .permitAll()
                                                        .requestMatchers(GET,
                                                                        String.format("%s/roles**", apiPrefix))
                                                        .permitAll()

                                                        .requestMatchers(GET,
                                                                        String.format("%s/categories/**", apiPrefix))
                                                        .permitAll()

                                                        .requestMatchers(GET,
                                                                        String.format("%s/products/**", apiPrefix))
                                                        .permitAll()

                                                        .requestMatchers(GET,
                                                                        String.format("%s/products/images/*",
                                                                                        apiPrefix))
                                                        .permitAll()

                                                        .requestMatchers(GET,
                                                                        String.format("%s/orders/**", apiPrefix))
                                                        .permitAll()

                                                        .requestMatchers(GET,
                                                                        String.format("%s/order_details/**", apiPrefix))
                                                        .permitAll()

                                                        .anyRequest()
                                                        .authenticated();
                                })
                                .csrf(AbstractHttpConfigurer::disable);
                http.securityMatcher(String.valueOf(EndpointRequest.toAnyEndpoint()));

                return http.build();
        }
}
