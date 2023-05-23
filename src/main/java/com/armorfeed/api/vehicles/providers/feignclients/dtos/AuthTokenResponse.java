package com.armorfeed.api.vehicles.providers.feignclients.dtos;

import lombok.Getter;

@Getter
public class AuthTokenResponse {
    private boolean isValidToken;
    private String message;
}
