package com.dealflowbus.gui.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;


@Component
public class FeignClientInterceptor implements RequestInterceptor {

    private final AccessToken accessToken;

    private static final String AUTH_HEADER = "authorization";


    public FeignClientInterceptor(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {

        String token = accessToken.getToken();

        requestTemplate.header(AUTH_HEADER, token);
    }


}
