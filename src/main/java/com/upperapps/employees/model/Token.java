package com.upperapps.employees.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Token {
    @JsonProperty("access_token")
    private final String accessToken;
    @JsonProperty("expires_in")
    private final Integer expiresIn;
    @JsonProperty("token_type")
    private final String tokenType;
}
