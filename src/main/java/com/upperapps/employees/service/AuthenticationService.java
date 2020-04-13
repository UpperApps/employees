package com.upperapps.employees.service;

import com.upperapps.employees.config.AppConfig;
import com.upperapps.employees.model.Token;
import com.upperapps.employees.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthenticationService {

    private RestTemplate restTemplate;
    private AppConfig appConfig;

    @Autowired
    public AuthenticationService(RestTemplateBuilder restTemplateBuilder, AppConfig appConfig) {
        this.restTemplate = restTemplateBuilder.build();
        this.appConfig = appConfig;
    }

    public Token getToken(User user) {
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("client_id", appConfig.getClientId());
        form.add("client_secret", appConfig.getClientSecret());
        form.add("grant_type", appConfig.getGrantType());
        form.add("scope", appConfig.getScope());
        form.add("username", user.getUserName());
        form.add("password", user.getPassword());

        var request = new HttpEntity<>(form, headers);

        var url = String.format("%s/auth/realms/springbootkeycloak/protocol/openid-connect/token",
                appConfig.getAuthenticationServerAddress());

        Token token = restTemplate.postForEntity(url, request, Token.class).getBody();
        
        return token;
    }

}