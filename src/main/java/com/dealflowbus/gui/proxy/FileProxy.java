package com.dealflowbus.gui.proxy;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "database-main-reader-files", url = "http://34.102.169.103")
public interface FileProxy {

    @RequestMapping(method = RequestMethod.GET, value = "/api/files/{id}")
    byte[] getFile(@PathVariable("id") String id, @RequestHeader("Authorization") String token);
}

