package com.dealflowbus.gui.config;

import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Component;


@Component
public class AccessToken {

    public String getToken() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String token;

        if (authentication != null && authentication.getDetails() instanceof OAuth2AuthenticationDetails) {
            OAuth2AuthenticationDetails details =
                    (OAuth2AuthenticationDetails) authentication.getDetails();

            token = String.format("%s %s", details.getTokenType(), details.getTokenValue());

        } else {
            throw new AuthorizationServiceException("You dont have authorization to perform this operation, token is missing");
        }
        return token;
    }
}
