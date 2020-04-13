package com.upperapps.employees.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class OAuth2LoginSecurityConfig extends ResourceServerConfigurerAdapter {

    private AppConfig config;

    @Autowired
    public OAuth2LoginSecurityConfig(AppConfig config) {
        this.config = config;
    }
    
    @Override
    public void configure(final ResourceServerSecurityConfigurer resources) throws Exception {

        System.out.println("Resouruce ID: " + config.getResourceId());
        System.out.println("Server: " + config.getServerAddress());
        resources.resourceId(config.getResourceId());
    }

    @Override
    public void configure(final HttpSecurity http) throws Exception {

        http.anonymous().and()
        .authorizeRequests().antMatchers("/login").permitAll()
        .antMatchers("/api/**").authenticated();
    }

}