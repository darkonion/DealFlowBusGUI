package com.dealflowbus.gui.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Component;


@Component
public class AccessToken {

    private final OAuth2RestTemplate oAuth2RestTemplate;

    public AccessToken(@Qualifier("myRestTemplate") OAuth2RestTemplate oAuth2RestTemplate) {this.oAuth2RestTemplate = oAuth2RestTemplate;}


    public String getToken() {

        OAuth2AccessToken accessToken = oAuth2RestTemplate.getAccessToken();
        String token = String.format("%s %s", accessToken.getTokenType(), accessToken.getValue());

        return token;
    }
}
