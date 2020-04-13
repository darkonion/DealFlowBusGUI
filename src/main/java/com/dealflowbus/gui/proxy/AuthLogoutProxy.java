package com.dealflowbus.gui.proxy;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "auth-service", url = "http://34.102.169.103")
public interface AuthLogoutProxy {

    @RequestMapping(value = "/uaa/oauth/logmeout", method = RequestMethod.GET)
    void logmeout();

}

