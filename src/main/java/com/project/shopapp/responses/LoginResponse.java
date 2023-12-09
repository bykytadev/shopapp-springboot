package com.project.shopapp.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {
    @JsonProperty("message")
    private String message;

    @JsonProperty("token")
    private String token;

    @JsonProperty("refresh_token")
    private String refreshToken;
    private String tokenType = "Bearer";

    // user's detail
    private Long id;
    private String username;

    private List<String> roles;
}
