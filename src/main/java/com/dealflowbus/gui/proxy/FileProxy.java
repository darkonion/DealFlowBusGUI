package com.dealflowbus.gui.proxy;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;


@FeignClient(name = "database-main-reader-files", url = "${dbURI}")
public interface FileProxy {


    @RequestMapping(method = RequestMethod.GET, value = "/api/files/{id}")
    byte[] getFile(@PathVariable("id") String id);

    @RequestMapping(method = RequestMethod.POST, value = "/api/leads/{id}/files", consumes = {"multipart/form-data"})
    void postFile(@PathVariable("id") int id, @RequestPart MultipartFile file);

    @RequestMapping(method = RequestMethod.DELETE, value = "/api/files/{id}")
    void deleteFile(@PathVariable("id") String id);
}

