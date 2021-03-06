package com.upperapps.employees.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "global")
@Getter
@Setter
public class AppConfig {
    private String clientId;
    private String authenticationServerAddress;
    private String clientSecret;
    private String grantType;
    private String scope;
}