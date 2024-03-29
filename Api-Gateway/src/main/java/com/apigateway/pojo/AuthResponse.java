package com.apigateway.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    private String userId;
    private String accessToken;
    private String refreshToken;
    private long expiresAt;
    private Collection<String> authorities;
}
